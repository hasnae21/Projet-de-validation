package prototype.todolist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import prototype.todolist.R
import prototype.todolist.models.Task


class TaskRecyclerViewAdapter(private val tasks: ArrayList<Task>, navController: NavController )
    : RecyclerView.Adapter<TaskRecyclerViewAdapter.DataViewHolder>() {

    private val navController = navController

    class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val taskTitle: TextView = view.findViewById<Button>(R.id.taskTitle)
        val taskPriority: TextView = view.findViewById<Button>(R.id.taskPriority)
        val taskTimestamp: TextView = view.findViewById<Button>(R.id.taskTimestamp)
        val cardView: CardView = view.findViewById(R.id.cardview)
        fun bind(task: Task) {
            taskTitle.text = task.title
            taskPriority.text = task.priority.toString()
            taskTimestamp.text = task.timestamp.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.task_item, parent, false)
        return DataViewHolder(layout)
    }

    override fun getItemCount(): Int  = tasks.size

    override fun onBindViewHolder(dataViewHolder: DataViewHolder, position: Int) {

        val task = tasks[position]
        dataViewHolder.bind(task)

        dataViewHolder.cardView.setOnClickListener {
            // update
            val action = TaskManagerFragmentDirections.actionTaskManagerFragmentToTaskFormFragment(taskid = task.id )
            navController.navigate(action)
        }
    }

    fun addTasks(tasks: List<Task>) {
        this.tasks.apply {
            clear()
            addAll(tasks)
        }

    }


}