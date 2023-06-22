<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */

    public function up()
    {
    Schema::create('favorites', function (Blueprint $table) {
        $table->id();

        $table->string('word');

            $table->string('phoneticT')->nullable();
            $table->text('def')->nullable();
            $table->text('syn')->nullable();
            $table->text('ano')->nullable();
            $table->text('exp')->nullable();
        
        $table->timestamps();
        
        $table->bigInteger("user_id")->unsigned();
        $table->foreign("user_id")
                ->references("id")
                ->on('users')
                ->onDelete('cascade');
    });
    }


    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('favorites');
    }
};
