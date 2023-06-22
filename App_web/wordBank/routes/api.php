<?php

use App\Http\Controllers\FavoriteController;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});


Route::post('login',[FavoriteController::class,'verifyUser']);

Route::get('/favorites/{id}',[FavoriteController::class,'findById']);
Route::post('/favorites/{id}',[FavoriteController::class,'store']);
Route::delete('/favorites/{id}',[FavoriteController::class,'destroy']);

Route::get('/favorites/getDuplicateWords',[FavoriteController::class,'getDuplicateWords']);