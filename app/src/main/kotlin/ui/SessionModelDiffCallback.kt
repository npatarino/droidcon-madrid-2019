package ui

import androidx.recyclerview.widget.DiffUtil

class SessionModelDiffCallback: DiffUtil.ItemCallback<SessionModel>() {
    override fun areItemsTheSame(oldItem: SessionModel, newItem: SessionModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: SessionModel, newItem: SessionModel): Boolean =
        oldItem == newItem
}