package prototype.todolist

import prototype.todolist.data.TaskDao
import prototype.todolist.data.TaskEntry
import prototype.todolist.data.TaskRepository

fun main (){
    print("Programme de Test")
    val taskRepository = TaskRepository()
    // Ajouter une tâche
    val task = TaskEntry(1,"Task 1",1,System.currentTimeMillis())
    taskRepository.save(task);

    // Suprimer une tâche

    // Modifier une tâche

    // Afficher les tâches


}