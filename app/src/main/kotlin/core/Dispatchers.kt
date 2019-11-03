package core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val defaultDispatcher: CoroutineDispatcher
    get() = Dispatchers.Default

actual val uiDispatcher: CoroutineDispatcher
    get() = Dispatchers.Main