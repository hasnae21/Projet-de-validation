<?php

namespace App\Http\Controllers\API;

use App\Http\Controllers\Controller;
use App\Models\Word;
use App\Models\Favory;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Http;
use Illuminate\Support\Facades\DB;

class WordController extends Controller
{
    public function saveApiData(Request $request)
    {

        $word_value = $request->input('value');
        $words = json_decode(file_get_contents('https://api.dictionaryapi.dev/api/v2/entries/en/{$word_value}'), true);

        if ($words) {
            foreach ($words as $word) {
                Word::create([
                    'word' => $word['word']
                ]);
            }

            //$user = User::find($id);
            $wordID = Word::find('id')->where('word', '=' ,'word_value');
            //$user->words()->attach($wordID);

            Favory::create([
                'word_id' => $wordID,
                'user_id' => 1
            ]);

        return redirect()->back()->with('success', 'API data saved successfully!');
    } else {
        return redirect()->back()->with('error', 'Unable to save API data.');
    }


    }

    // public function getall()
    // {
    //     return Word::all()->get()->toArray();
    // }

    // function addFavory(Request $request){
    //     $input = $request->all();
    //     $favorite = Favory::create($input);
    //     return $favorite;
    // }

    public function getFavory(Request $request){

        $list=Favory::join('words','words.id','=','favories.words_id')
            ->join('users','users.id', '=', 'favories.user_id')
            ->where('favories.user_id',$request->iduser)
            ->select(['favories.id AS fvid','favories.words_id','favories.user_id','words.word','users.name','users.id','users.email','users.password'])
            ->get();

        return $list;
    }


    public function destroy(string $id)
    {
        return Favory::findOrFail($id)->delete();
    }
}
