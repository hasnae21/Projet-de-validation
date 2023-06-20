<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Favory extends Model
{
    use HasFactory;
    protected $table="favories";
    protected $fillable=["word_id","user_id"];
}
