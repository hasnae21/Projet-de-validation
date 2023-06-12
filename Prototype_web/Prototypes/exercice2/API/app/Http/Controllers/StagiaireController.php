<?php

namespace App\Http\Controllers;

use App\Models\cf;
use App\Models\Stagiaire;
use Illuminate\Http\Request;

class StagiaireController extends Controller
{
    public function index(Request $request)
    {
        $Stagiaire= Stagiaire::where('Prenom' ,'LIKE', $request->Nom.'%')->get();
        if(!empty($Stagiaire[0]))
        return ['message'=>$Stagiaire];
        else
        return ['message'=>"exist pas"];
    }
}
