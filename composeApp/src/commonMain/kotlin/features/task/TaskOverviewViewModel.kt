package features.task

import androidx.lifecycle.viewModelScope
import core.ui.BaseViewModel
import kotlinx.coroutines.launch
import repository.TaskRepository

class TaskOverviewViewModel(
    private val taskRepository: TaskRepository
) : BaseViewModel<TaskOverviewViewState>(TaskOverviewViewState()) {

    fun updateTasks() {
        viewModelScope.launch {
            val tasks = taskRepository.getTasks()
            updateState {
                copy(
                    tasks = tasks
                )
            }
        }
    }
}
