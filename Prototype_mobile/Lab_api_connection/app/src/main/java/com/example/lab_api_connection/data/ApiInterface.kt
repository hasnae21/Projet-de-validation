package com.example.lab_api_connection.data

import com.example.lab_api_connection.data.models.CurrentDictionary
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("{word}")
    suspend fun getDataFromDictionary(
        @Query("word") word: String,
    ):Response<CurrentDictionary>

}