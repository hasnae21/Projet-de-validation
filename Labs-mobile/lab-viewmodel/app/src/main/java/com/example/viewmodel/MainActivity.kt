package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private val scoreViewModel: ScoreViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        var value = 0
//        val change = findViewById<Button>(R.id.change)
//
//        change.setOnClickListener{
//            val score = findViewById<TextView>(R.id.score)
//            value++
//            score.setText(value.toString())
//        }
        //scoreViewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)

        val change = findViewById<Button>(R.id.change)

        change.setOnClickListener{
            scoreViewModel.increaseScore()
            updateScoreTextView()
        }
        updateScoreTextView()
    }
    private fun updateScoreTextView() {
        val score = findViewById<TextView>(R.id.score)
        val currentScore = scoreViewModel.getScore()
        score.text = "Score: $currentScore"
    }
}