package core

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.ios.Ios

@ThreadLocal
actual object PlatformServiceLocator {
    actual val httpClientEngine: HttpClientEngine
        get() = Ios.create()
}