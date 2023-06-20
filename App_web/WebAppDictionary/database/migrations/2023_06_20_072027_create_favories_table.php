<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('favories', function (Blueprint $table) {
            $table->id();

            $table->bigInteger("word_id")->unsigned()->nullable();
            $table->foreign("word_id")
                ->references("id")
                ->on('words')
                ->onDelete('cascade');

            $table->bigInteger("user_id")->unsigned()->nullable();
            $table->foreign("user_id")
                ->references("id")
                ->on('users')
                ->onDelete('cascade');

            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('favories');
    }
};
