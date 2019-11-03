package ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class PresenterScope(coroutineContext: CoroutineContext) : CoroutineScope {

    private val onViewDetachJob = Job()

    override val coroutineContext: CoroutineContext = coroutineContext + onViewDetachJob

    fun onViewDetached() {
        onViewDetachJob.cancel()
    }
}