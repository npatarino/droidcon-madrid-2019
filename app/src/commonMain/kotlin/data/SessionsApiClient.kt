package data

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.http.takeFrom
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class SessionsApiClient(
    httpClientEngine: HttpClientEngine,
    private val json: Json
) {

    private val httpClient = HttpClient(httpClientEngine)

    suspend fun getSessions(): List<SessionGroupDto> {
        val serializedSessions = httpClient.get<String> { sessionize("sessions") }
        return json.parse(SessionGroupDto.serializer().list, serializedSessions)
    }


    private fun HttpRequestBuilder.sessionize(path: String) {
        url {
            takeFrom(Constants.SESSIONIZE_ENDPOINT)
            encodedPath = path
        }
    }

    private object Constants {
        const val SESSIONIZE_ENDPOINT = "https://www.sessionize.com"
    }
}