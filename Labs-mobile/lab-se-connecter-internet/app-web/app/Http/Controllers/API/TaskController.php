<?php

namespace App\Http\Controllers\API;
 
use App\Http\Controllers\Controller;
use App\Models\Task;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Log;

class TaskController extends Controller
{
    public function findAll()
    {
        error_log('findAll');

        // On récupère tous les tâches
        $Tasks = Task::all();

        // On retourne les informations des tâches en JSON
        return response()->json($Tasks);
    }

    public function findById($id){

        error_log('findById');

        $task = Task::find($id);
        return response()->json($task);

    }

    public function store(Request $request)
    {
        error_log('store' );
        error_log($request);

        // La validation de données
        $this->validate($request, [
           'title' => 'required|max:100'
        ]);

        // On crée un nouvel tâche
        $Task = Task::create([
            'title' => $request->title,
            'priority' => $request->priority
        ]);

        // On retourne les informations du nouvel tâche en JSON
        return response()->json($Task, 201);
    }

    public function show(Task $Task)
    {
        // On retourne les informations de l'tâche en JSON
        return response()->json($Task);
    }

    public function update(Request $request, Task $Task)
    {
        error_log('update' . $Task );
        error_log('update' . $request );
        


        // La validation de données
        $this->validate($request, [
           'title' => 'required|max:100'
        ]);

        // On modifie les informations de l'tâche
        $Task->update([
            "title" => $request->title,
            "priority" => $request->priority
        ]);
       // dd($request->title);
        // On retourne la réponse JSON
        return response()->json($Task);
    }

    public function destroy(Task $Task)
    {
        error_log('destroy' . $Task->id );
        // On supprime l'tâche
        $Task->delete();

       

        // On retourne la réponse JSON
        return response()->json();
    }
}