package core

import io.ktor.client.engine.HttpClientEngine

expect object PlatformServiceLocator {
    val httpClientEngine: HttpClientEngine
}