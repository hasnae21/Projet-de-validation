package prototype.todolist.dao

import prototype.todolist.dao.api.TasksApiInterface
import prototype.todolist.models.Task
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TasksDao {

    companion object{

        private var BASE_URL = "http://192.168.2.14:8000/api/"

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build() //Doesn't require the adapter
        }
        val apiService: TasksApiInterface = getRetrofit().create(TasksApiInterface::class.java)
    }

    suspend fun getTasks() = apiService.getTasks()

    suspend fun findById(id : Int ) = apiService.findById(id)

    suspend fun delete(id : Int ) = apiService.delete(id)

    suspend fun save(task : Task ) = apiService.save(task)

    suspend fun update(task : Task ) = apiService.update(task.id, task)

}