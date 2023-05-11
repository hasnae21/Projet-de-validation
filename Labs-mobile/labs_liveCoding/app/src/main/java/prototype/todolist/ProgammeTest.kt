package prototype.todolist

import prototype.todolist.data.TaskEntry
import prototype.todolist.data.TaskRepository

fun main(){
    val taskRepository =TaskRepository()

//  val task1 = TaskEntry(1,"task1_AddedFromProgrammeTest",0,System.currentTimeMillis())
    val task1 = taskRepository.newTask()
    task1.id = 1
    task1.title = "task1_AddedFromProgrammeTest"
    task1.priority = 0
    task1.timestamp = System.currentTimeMillis()

    //Exemple Ajouter
    taskRepository.save(task1)

    //Exemple Modifier
    print("Enter the Id of the task to modify: ")
    val value = Integer.valueOf(readLine())
    val updateTask = taskRepository.findById(value)
    print("Modify the task title here: ")
    val newTask = readLine()
    updateTask.title = "$newTask"

    //Exemple Supprimer
    print("Give the id of the task you want delete: ")
    val enteredID = Integer.valueOf(readLine())
    taskRepository.delete(enteredID)

    //Exemple Afficher
    for(item in taskRepository.getAllTask() ){
        print("Task : ")
        print(item.id)
        print(item.title)
        print(item.priority)
        println(item.timestamp)
    }
}