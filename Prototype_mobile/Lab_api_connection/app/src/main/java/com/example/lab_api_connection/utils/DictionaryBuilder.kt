package com.example.lab_api_connection.utils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DictionaryBuilder {

    const val Base = "https://api.dictionaryapi.dev/api/v2/entries/en/"

//    private val client = OkHttpClient.Builder().build()
//
//    private val retrofit = Retrofit
//        .Builder()
//        .baseUrl("https://api.dictionaryapi.dev/api/v2/entries/en/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(client)
//        .build()

    //let's create an instance of this object
//    fun<T>buildDictionary(dictionary: Class<T>):T{
//        return retrofit.create(dictionary)
//    }
}