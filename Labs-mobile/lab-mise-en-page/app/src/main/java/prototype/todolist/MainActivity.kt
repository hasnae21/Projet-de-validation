package prototype.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
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
                val newTask = repository.newTask()
                newTask.title = "New task" + Random.nextInt()

//                val stringArray = resources.getStringArray(R.array.priorities)
//                val firstItem = stringArray[0]
//                val secondItem = stringArray[1]

//                val textView = findViewById<TextView>(R.id.taskPriority)
//                textView.text = "uefhizuefhiur"
//                if (newTask.priority === 1){
//                    textView.text = firstItem
//                }
//                else
//                    textView.text = secondItem

                repository.save(newTask)

                Toast.makeText(applicationContext,"Tâche ajouter", Toast.LENGTH_LONG).show()
                taskAdapter.notifyDataSetChanged()
            }
        }
    }
}