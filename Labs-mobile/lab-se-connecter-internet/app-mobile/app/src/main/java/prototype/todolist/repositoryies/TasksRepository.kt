package prototype.todolist.repositoryies

import prototype.todolist.dao.TasksDao
import prototype.todolist.models.Task

class TasksRepository () {

    private val tasksDao = TasksDao()

    suspend fun getTasks() = tasksDao.getTasks()

    suspend fun findById(id : Int) = tasksDao.findById(id)

    suspend fun delete(id : Int) = tasksDao.delete(id)

    suspend fun save(task : Task){
        if(task.id == 0){
            // save
            tasksDao.save(task)
        }else{
            // update
            tasksDao.update(task)
        }

    }
}