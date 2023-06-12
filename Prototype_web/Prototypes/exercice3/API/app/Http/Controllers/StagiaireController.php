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
        return json_encode($Stagiaire);
    }
    public function show($id)
    {
        $Stagiaire= Stagiaire::where('id' ,'LIKE', $id)->get();
        return json_encode($Stagiaire);
    }
}
