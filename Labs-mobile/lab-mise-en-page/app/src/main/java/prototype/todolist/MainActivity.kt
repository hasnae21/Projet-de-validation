package prototype.todolist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import prototype.todolist.data.TaskRepository
import prototype.todolist.databinding.ActivityMainBinding
import prototype.todolist.ui.TaskAdapter
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {

            val taskAdapter = TaskAdapter(applicationContext)
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.adapter =  taskAdapter

            floatingActionButton.setOnClickListener{

                val repository = TaskRepository()
                val newTask = repository.newTask()
                newTask.title = "New task" + Random.nextInt()
                repository.save(newTask)

                Toast.makeText(applicationContext,"Task added", Toast.LENGTH_LONG).show()
                taskAdapter.notifyDataSetChanged()
            }
        }
    }
}