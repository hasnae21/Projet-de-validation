package prototype.todolist.dao.api

import prototype.todolist.models.Task
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface TasksApiInterface {

    @GET("tasks/find_all")
    suspend fun getTasks(): List<Task>

    @GET("tasks/find_by_id/{id}")
    suspend fun findById(@Path("id") id : Int) : Task

    @DELETE("tasks/{id}")
    suspend fun delete(@Path("id") id : Int) : Int

    @POST("tasks/")
    suspend fun save(@Body task : Task) : Task

    @PATCH("tasks/{id}")
    suspend fun update(@Path("id") id : Int, @Body task : Task) : Task

}
