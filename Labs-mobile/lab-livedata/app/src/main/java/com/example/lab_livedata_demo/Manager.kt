package com.example.lab_livedata_demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Manager : ViewModel() {

    // Create a LiveData with a String
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        currentName.value = "Tanger"
    }

    // Rest of the ViewModel...
}