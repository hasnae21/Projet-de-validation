package com.example.lab_api_connection.data.models

data class CurrentDictionaryItem(
    val license: License,
    val meanings: List<Meaning>,
    val phonetics: List<Phonetic>,
    val sourceUrls: List<String>,
    val word: String
)