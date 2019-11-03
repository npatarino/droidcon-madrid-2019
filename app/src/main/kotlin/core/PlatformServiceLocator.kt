package core

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import ui.SessionModelDiffCallback
import ui.SessionsAdapter

actual object PlatformServiceLocator {
    actual val httpClientEngine: HttpClientEngine
        get() = OkHttp.create()

    val sessionsAdapter: SessionsAdapter
        get() = SessionsAdapter(sessionsDiffCallback)

    private val sessionsDiffCallback by lazy { SessionModelDiffCallback() }
}