package com.example.lab_livedata_demo
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

import com.example.lab_livedata_demo.Manager
import com.example.lab_livedata_demo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // Use the 'by viewModels()' Kotlin property delegate
    // from the activity-ktx artifact
    private val model :Manager by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Other code to setup the activity...

          var binding = ActivityMainBinding.inflate(layoutInflater)
        binding.nameTextView.text = model.currentName.value
        setContentView(binding.root)

        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            binding.nameTextView.text = "${newName} +"

        }
        binding.incrementButton.setOnClickListener{
             model.currentName.value = "hello nada"
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)
    }
}