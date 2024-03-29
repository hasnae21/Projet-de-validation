package prototype.todolist

import prototype.todolist.data.TaskDao
import prototype.todolist.data.TaskEntry
import prototype.todolist.data.TaskRepository

fun main (){
// data class
/*
    val task1 = TaskEntry(1,"Task 1",1,null)
    val task2 = TaskEntry(1,"Task 1",1,null)
    println(task1.equals(task2))
    println(task1.toString())
*/

    val taskrepo = TaskRepository()
    //println(taskrepo.newTask())

    val task1 = TaskEntry(0,"TaskTest1",1,null)
    //println(task1)

    // Exemple Ajouter
    taskrepo.save(task1)


    // Exemple Modifier
    print("Give the id of the task you want modify: ")
    val enteredValue = Integer.valueOf(readLine())
    val updateTask = taskrepo.findById(enteredValue)

    print("Modify the task title here: ")
    val enteredString = readLine()
    updateTask.title = "$enteredString"

    //taskrepo.save(updateTask)   had stal maxi darouri car le variable est passer par address
    //println(updateTask)

    // Exemple Supprimer
    print("Give the id of the task you want delete: ")
    val enteredID = Integer.valueOf(readLine())
    taskrepo.delete(enteredID)

    // Exemple Afficher
    for(item in taskrepo.getAllTasks() ){
        print("Task infos :")
        print(item.id)
        print(",")
        print(item.title)
        print(",")
        println(item.priority)
    }
}