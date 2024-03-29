package prototype.todolist.data

class TaskRepository() {

    private val taskDao = TaskDao()

    private fun insert(taskEntry: TaskEntry) = taskDao.insert(taskEntry)
    private fun update(taskEntry: TaskEntry) = taskDao.update(taskEntry)

    fun findById(id:Int) = taskDao.findById(id)
    fun getAllTask() = taskDao.getAllTask()
    fun delete(taskId: Int) = taskDao.delete(taskId)


    fun newTask(): TaskEntry {
        return TaskEntry(0,"",1, System.currentTimeMillis())
    }

    fun save(taskEntry: TaskEntry){
        if(taskEntry.id == 0)
            this.insert(taskEntry)
        else
            this.update(taskEntry)
    }
}