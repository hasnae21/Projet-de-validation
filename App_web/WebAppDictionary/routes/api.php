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

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});



use App\Http\Controllers\API\WordController;

// Les routes "users.*" de l'API

// Route::post('/login', [AuthController::class,'login']);
// Route::post('/register',[AuthController::class,'register']);
// Route::get('users',[AuthController::class,'users']);
// Route::post('logout',[AuthController::class,'logout']);

