package ui

import core.uiDispatcher
import domain.GetSessions
import domain.Session
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SessionsPresenter(
    private val getSessions: GetSessions,
    coroutineContext: CoroutineContext
) {

    private val presenterScope = PresenterScope(coroutineContext)

    private lateinit var sessionsView: SessionsView

    fun onAttach(sessionsView: SessionsView) {
        this.sessionsView = sessionsView
        presenterScope.launch(uiDispatcher) {
            val sessions = getSessions().map(Session::toUIModel)
            sessionsView.showSessions(SessionsModel(sessions))
        }
    }

    fun onDetach() {
        presenterScope.onViewDetached()
    }
}