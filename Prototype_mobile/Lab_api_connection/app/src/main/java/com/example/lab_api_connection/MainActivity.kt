package com.example.lab_api_connection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_api_connection.databinding.ActivityMainBinding
import com.example.lab_api_connection.utils.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.util.function.IntFunction

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataFromDictionary()

//        binding.recyclerview.layoutManager = LinearLayoutManager(this)
//        getAllProducts()
    }

    private fun getDataFromDictionary() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = try {
                RetrofitInstance.api.getDataFromDictionary("hello")
            }catch (e: IOException){
                Toast.makeText(applicationContext, "app error ${e.message}", Toast.LENGTH_SHORT).show()
                return@launch
            }catch (e: HttpException){
                Toast.makeText(applicationContext, "app error ${e.message}", Toast.LENGTH_SHORT).show()
                return@launch
            }
        }
    }

//    private fun getAllProducts() {
//    }
}