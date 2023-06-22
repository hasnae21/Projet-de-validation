<?php

namespace App\Http\Controllers;

use App\Models\Favorite;
use App\Models\User;
use Illuminate\Http\Request;

class FavoriteController extends Controller
{
  
    // get data from my database "Afficher la list de tous les favoris"
    public function findById($id)  
    {  
        error_log('findById');

        $favorites = Favorite::where('user_id', $id)->get();
        return response()->json($favorites);
    }


    // store data in my database "Ajouter un favori"
    public function store(Request $request,$id)
    {

        error_log('store'. $data);

        if (Favorite::where('word', $request->word)->where('user_id', $id)->exists()) {
            return response()->json(['message' => 'Data exists.']);
        } else {

            $client = new \GuzzleHttp\Client([
                'verify' => false,
            ]);

            $res = $client->request('GET', "https://api.dictionaryapi.dev/api/v2/entries/en/" . $request->word);
            $data = json_decode($res->getBody(), true);

            foreach ($data as $value) {
                $favorite = new Favorite();
                $favorite->user_id = $id;
                $favorite->word = $value['word'];
                $favorite->phoneticT = $value['phonetics'][0]['text'] ?? null;
                $favorite->def = $value['meanings'][0]['definitions'][0]['definition'] ?? null;

                $favorite->syn = $value['meanings'][0]['synonyms'][0] ?? null;
                $favorite->ano = $value['meanings'][0]['antonyms'][0] ?? null;
                // $favorite->syn = implode(',', $value['meanings'][0]['definitions'][0]['synonyms'] ?? []);
                // $favorite->ano = implode(',', $value['meanings'][0]['definitions'][0]['antonyms'] ?? []);

                $favorite->exp = $value['meanings'][0]['definitions'][0]['example'] ?? null;
                $favorite->save();
            }

            return response()->json($favorite, 201, ['message' => 'Data stored successfully.']);
            // response()->json(['message' => 'Data stored successfully.']);
        }
    }


    // delete data from my database "Suprimer un favori"
    public function destroy(Request $request, $id)  
    {  
        $data = Favorite::where('user_id', $id)->where('word', $request->word)->first();
        
        if ($data) {
            $data->delete();
            return response()->json(['message' => 'Data deleted successfully.']);
        } else {
            return response()->json(['message' => 'Data not exists.']);
        }
    }


    // afficher les mot rechercher par plusieurs user
    public function getDuplicateWords()
    {
        $duplicates = Favorite::select('word')
            ->groupBy('word')
            ->havingRaw('COUNT(DISTINCT user_id) > 1')
            ->get();

        return response()->json($duplicates);
    }


    // verify a user in the database if exist or not
    public function verifyUser(Request $request)
    {
        $email = $request->input('email');
        $password = $request->input('password');
        $hash = password_hash($password, PASSWORD_BCRYPT);

        $user = User::where('email', $email)->first();
        if (!$user) {
            return response()->json(['message' => 'User not found.'], 404);
        }
        if (!password_verify($password, $hash)) {
            return response()->json(['message' => 'Incorrect password.'], 401);
        }

        return response()->json(['name' => $user->name], 200);
    }

}