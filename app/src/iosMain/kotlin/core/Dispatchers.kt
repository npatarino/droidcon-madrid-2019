package core

import kotlinx.coroutines.CoroutineDispatcher

actual val defaultDispatcher: CoroutineDispatcher
    get() = IosMainDispatcher
actual val uiDispatcher: CoroutineDispatcher
    get() = IosMainDispatcher