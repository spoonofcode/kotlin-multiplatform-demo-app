package di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

val appModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }
    }

//    singleOf(::TaskRepository)
}