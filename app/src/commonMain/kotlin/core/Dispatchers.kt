package core

import kotlinx.coroutines.CoroutineDispatcher

expect val defaultDispatcher: CoroutineDispatcher
expect val uiDispatcher: CoroutineDispatcher