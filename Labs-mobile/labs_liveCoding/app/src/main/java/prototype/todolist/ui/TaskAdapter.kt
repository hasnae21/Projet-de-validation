package prototype.todolist.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import prototype.todolist.R
import prototype.todolist.data.TaskRepository
import java.text.SimpleDateFormat

class TaskAdapter(private val context: Context) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val taskRepository = TaskRepository()
    class TaskViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val taskTitle: TextView = view.findViewById<Button>(R.id.taskTitle)
        val taskPriority: TextView = view.findViewById<Button>(R.id.taskPriority)
        val taskTimestamp: TextView = view.findViewById<Button>(R.id.taskTimestamp)
        val cardView: CardView = view.findViewById(R.id.cardview)
        val stringArray:Array<String> = view.resources.getStringArray(R.array.priorities)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return taskRepository.getAllTask().size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(taskViewHolder: TaskViewHolder, position: Int) {
        val task = this.taskRepository.getAllTask()[position]
        taskViewHolder.taskTitle.text = task.title

        if (task.priority == 0){
            taskViewHolder.taskPriority.text = taskViewHolder.stringArray[0]
        }
        else if (task.priority == 1){
            taskViewHolder.taskPriority.text = taskViewHolder.stringArray[1]
        }
        else if (task.priority == 2){
            taskViewHolder.taskPriority.text = taskViewHolder.stringArray[2]
        }

        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        taskViewHolder.taskTimestamp.text = format.format(task.timestamp)

        taskViewHolder.cardView.setOnClickListener {

            task.title = task.title + "+"

            // Supprimer ces deux lignes et voir est ce que RecyclerView continue d'afficher les updates ?
            //le titre est modifier a cause de la ligne 60
            //val repository = TaskRepository()
            //repository.save(task)

            this.notifyDataSetChanged()

            // Afficher un message aprés Update
            Toast.makeText(context,"Task updated", Toast.LENGTH_LONG).show()
        }

    }

}