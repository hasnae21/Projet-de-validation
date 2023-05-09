package prototype.todolist

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import prototype.todolist.data.TaskEntry
import prototype.todolist.data.TaskRepository
import prototype.todolist.databinding.ActivityMainBinding
import prototype.todolist.ui.TaskAdapter
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            val taskAdapter = TaskAdapter()
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.adapter =  taskAdapter
            floatingActionButton.setOnClickListener{

                val repository = TaskRepository()
                val newTask = repository.newTask();
                newTask.title = "New task" + Random.nextInt()
                repository.save(newTask)

                Toast.makeText(applicationContext,"Ajouter une tâche", Toast.LENGTH_LONG).show()
                taskAdapter.notifyDataSetChanged()
            }

        }

    }

}