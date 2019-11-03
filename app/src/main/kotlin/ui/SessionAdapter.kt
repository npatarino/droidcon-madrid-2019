package ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sample.R

class SessionsAdapter(
    sessionModelDiffCallback: SessionModelDiffCallback
) : ListAdapter<SessionModel, SessionViewHolder>(sessionModelDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder =
        SessionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.session_row,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        val session = getItem(position)
        holder.bind(session)
    }
}

class SessionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(session: SessionModel) {
        itemView.findViewById<TextView>(R.id.sessionTitle).text = session.title
        itemView.findViewById<TextView>(R.id.sessionAdditionalInfo).text = session.additionalInfo
        itemView.findViewById<TextView>(R.id.sessionTime).text = session.time
        itemView.findViewById<TextView>(R.id.timePeriod).text = session.timePeriod
        itemView.findViewById<TextView>(R.id.sessionCategory).text = session.category
    }
}

