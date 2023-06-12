<?php
namespace App\Http\Controllers;

use App\Models\cf;
use App\Models\Stagiaire;
use Illuminate\Http\Request;

class StagiaireController extends Controller
{
    public function index(Request $request)
    {
        $Stagiaire= Stagiaire::where('Prenom',$request->Nom)->get();
        if(!empty($Stagiaire[0])){
        return ['message'=>"exist"];
    }else{
        return ['message'=>"exist pas"];
    }
    }
}
