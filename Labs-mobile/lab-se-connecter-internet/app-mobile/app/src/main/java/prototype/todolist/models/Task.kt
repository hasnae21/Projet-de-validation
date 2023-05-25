package prototype.todolist.models

import com.google.gson.annotations.SerializedName

data class Task  (
    var id: Int,
    @SerializedName("title")
    var title: String,
    var priority: Int,
    var timestamp: Long
)

