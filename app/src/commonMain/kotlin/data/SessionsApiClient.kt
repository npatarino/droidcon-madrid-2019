package data

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.request.get
import io.ktor.client.request.url

class SessionsApiClient(httpClientEngine: HttpClientEngine) {

    private val httpClient = HttpClient(httpClientEngine)

    suspend fun getSessions(): List<SessionDto> =
        httpClient.get { url(Constants.SESSIONIZE_ENDPOINT) }

    private object Constants {
        const val SESSIONIZE_ENDPOINT = "https://www.sessionize.com"
    }
}