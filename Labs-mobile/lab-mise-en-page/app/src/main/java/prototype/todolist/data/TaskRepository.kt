package prototype.todolist.data

class TaskRepository () {

    private val taskDao = TaskDao()
    private fun insert(taskEntry: TaskEntry) = taskDao.insert(taskEntry)
    private fun update(taskEntry: TaskEntry) = taskDao.update(taskEntry)
    fun delete(taskId: Int) = taskDao.delete(taskId)
    fun getAllTasks() = taskDao.getAllTasks()
    fun findById(id: Int) = taskDao.findById(id)
    fun newTask(): TaskEntry {
        return TaskEntry(0,"",0,System.currentTimeMillis())
    }

    fun save(taskEntry: TaskEntry) {

        if(taskEntry.id == 0){
            this.insert(taskEntry)
        }else{
            this.update(taskEntry)
        }
    }
}