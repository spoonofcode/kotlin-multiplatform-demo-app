import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id: Int,
    val description: String,
    val creationDate: LocalDateTime,
    val updateDate: LocalDateTime,
    val isCompleted: Boolean,
    val categoryId: Int,
    val userId: Int,
)