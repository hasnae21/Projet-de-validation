package com.example.lab_api_connection.data

import com.example.lab_api_connection.data.models.CurrentDictionary
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

//    @GET("https://api.dictionaryapi.dev/api/v2/entries/en/hello")

    suspend fun getDataFrmDictionary(

        @Query("word") word: String,

    ):Response<CurrentDictionary>

//    abstract fun getDataFromDictionary(s: String): Nothing
}