import features.task.TaskOverviewViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewModelModule = module {
    singleOf(::TaskOverviewViewModel)
}