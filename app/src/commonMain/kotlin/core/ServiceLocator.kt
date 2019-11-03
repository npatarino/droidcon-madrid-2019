package core

import data.network.FakeSessionsApiClient
import data.network.RealSessionsApiClient
import data.repository.SessionsRepository
import domain.GetSessions
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import ui.SessionsPresenter
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object ServiceLocator {

    private val sessionsApiClient
        get() = FakeSessionsApiClient()
    /*get() = RealSessionsApiClient(
        PlatformServiceLocator.httpClientEngine,
        Json(JsonConfiguration.Stable.copy(strictMode = false))
    )*/

    private val sessionsRepository by lazy { SessionsRepository(sessionsApiClient) }

    private val getSessions
        get() = GetSessions(sessionsRepository)

    val sessionsPresenter
        get() = SessionsPresenter(getSessions, defaultDispatcher)
}