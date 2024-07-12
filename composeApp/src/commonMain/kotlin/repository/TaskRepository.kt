package repository

import model.Task
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class TaskRepository(
    val httpClient: HttpClient
) {

    suspend fun getTasks(): List<Task> {
        val tasks = httpClient
            .get("http://$HOST:$PORT/tasks/")
            .body<List<Task>>()
        return tasks
    }
}