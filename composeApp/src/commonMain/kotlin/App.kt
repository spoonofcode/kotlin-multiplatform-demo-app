import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import features.task.TaskOverview
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        MaterialTheme {
            TaskOverview()
        }
    }
}