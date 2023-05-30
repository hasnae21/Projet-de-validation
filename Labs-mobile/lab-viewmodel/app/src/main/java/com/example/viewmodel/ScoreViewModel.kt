package com.example.viewmodel

import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private var score: Int = 0
    fun getScore(): Int {
        return score
    }

    fun increaseScore() {
        score++
    }
}