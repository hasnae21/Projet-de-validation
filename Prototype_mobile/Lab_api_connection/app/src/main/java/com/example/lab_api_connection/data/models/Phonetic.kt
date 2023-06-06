package com.example.lab_api_connection.data.models

data class Phonetic(
    val audio: String,
    val license: License,
    val sourceUrl: String,
    val text: String
)