<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

// Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
//     return $request->user();
// });

use App\Http\Controllers\API\TaskController;


 // Route::apiResource("tasks", TaskController::class); // Les routes "users.*" de l'API


Route::get('/tasks/find_all/', [TaskController::class, 'findAll']);
Route::get('/tasks/find_by_id/{id}', [TaskController::class, 'findById']);
Route::delete('/tasks/{task}', [TaskController::class, 'destroy']);
Route::post('/tasks', [TaskController::class, 'store']);
Route::match(['put', 'patch'], '/tasks/{task}',[TaskController::class, 'update']);

// Route::post('/tasks', [TaskController::class, 'store']);
// Route::get('/tasks', [TaskController::class, 'index']);
// Route::put('/tasks/complete', [TaskController::class, 'complete']);
// Route::delete('/tasks/{task}', [TaskController::class, 'delete']);
// Route::get('/tasks/filter', [TaskController::class, 'filter']);