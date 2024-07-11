import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// For Android emulator
private const val HOST = "10.0.2.2"
private const val PORT = "8100"

data class TaskOverviewViewState(
    val tasks: List<Task> = emptyList(),
)

class TaskOverviewViewModel : ViewModel() {
    private val _viewState = MutableStateFlow(TaskOverviewViewState())
    val viewState = _viewState.asStateFlow()

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    override fun onCleared() {
        httpClient.close()
    }

    fun updateTasks() {
        viewModelScope.launch {
            val tasks = getTasks()
            _viewState.update {
                it.copy(tasks = tasks)
            }
        }
    }

    private suspend fun getTasks(): List<Task> {
        val tasks = httpClient
            .get("http://$HOST:$PORT/tasks/")
            .body<List<Task>>()
        return tasks
    }

}
