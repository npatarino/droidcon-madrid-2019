package data.repository

import data.network.SpeakerDto

data class SessionData(
    val id: String,
    val title: String,
    val description: String?,
    val startsAt: String?,
    val endsAt: String?,
    val isServiceSession: Boolean,
    val isPlenumSession: Boolean,
    val speakers: List<SpeakerDto>,
    val category: String,
    //val categories: List<CategoryDto>,
    val roomId: Int?,
    val room: String?
)