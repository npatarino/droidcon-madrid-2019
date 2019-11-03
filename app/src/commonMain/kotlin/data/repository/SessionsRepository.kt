package data.repository

import data.network.SessionsApiClient
import data.network.toDataModel

class SessionsRepository(
    private val sessionsApiClient: SessionsApiClient
) {

    suspend fun getAll(): List<SessionData> =
        sessionsApiClient.getSessions().flatMap { sessionsGroup ->
            sessionsGroup.sessions.map { networkSession ->
                networkSession.toDataModel(sessionsGroup.groupName)
            }
        }
}