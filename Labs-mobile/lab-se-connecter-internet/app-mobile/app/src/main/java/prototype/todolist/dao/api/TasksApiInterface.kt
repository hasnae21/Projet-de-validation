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

    @GET("favorites/{id}")
    suspend fun findById(@Path("id") id : Int) : Favorite

    @POST("favorites/{id}")
    suspend fun store(@Body favorite : Favorite) : Favorite

    @DELETE("favorites/{id}")
    suspend fun destroy(@Path("id") id : Int) : Int
}
