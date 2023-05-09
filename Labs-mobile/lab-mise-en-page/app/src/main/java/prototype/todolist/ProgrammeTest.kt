package prototype.todolist

import prototype.todolist.data.TaskDao
import prototype.todolist.data.TaskEntry
import prototype.todolist.data.TaskRepository

fun main (){
    println("Programme de Test")
    val taskRepository = TaskRepository()

    // Ajouter une tâche
    val task = TaskEntry(1,"Task 1",1,System.currentTimeMillis())
    taskRepository.save(task);

//    // Modifier une tâche
//    val updateTask = taskRepository.findById(1)
//    updateTask.title = "Task_Modifier"
//    taskRepository.save(updateTask)
//
//    // Suprimer une tâche
//    taskRepository.delete(2)

    // Afficher les tâches
    for(item in taskRepository.getAllTasks() ){
        println(item.title)
    }
}