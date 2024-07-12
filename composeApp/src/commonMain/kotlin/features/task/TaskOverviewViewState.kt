package features.task

import model.Task

data class TaskOverviewViewState(
    val tasks: List<Task> = emptyList(),
)