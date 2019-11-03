package data.network

interface SessionsApiClient {

    suspend fun getSessions(): List<SessionGroupDto>
}