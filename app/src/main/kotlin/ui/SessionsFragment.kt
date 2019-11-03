package ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import core.PlatformServiceLocator
import core.ServiceLocator
import sample.R

class SessionsFragment private constructor(): Fragment(), SessionsView {

    private val sessionsPresenter by lazy { ServiceLocator.sessionsPresenter }
    private val sessionsAdapter by lazy { PlatformServiceLocator.sessionsAdapter }

    private lateinit var sessions: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_sessions, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sessions = view.findViewById(R.id.sessions)
        sessions.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sessionsAdapter
        }

        sessionsPresenter.onAttach(this)
    }

    override fun onDestroyView() {
        sessionsPresenter.onDetach()
        super.onDestroyView()
    }

    override fun showSessions(sessionsModel: SessionsModel) {
        sessionsAdapter.submitList(sessionsModel.sessions)
    }

    companion object {
        fun build(): SessionsFragment = SessionsFragment()
        const val TAG = "tag:SessionsFragment"
    }
}