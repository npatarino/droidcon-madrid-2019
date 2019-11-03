package ui

data class SessionsModel(val sessions: List<SessionModel>)
data class SessionModel(
    val id: String,
    val title: String,
    val additionalInfo: String,
    val time: String,
    val timePeriod: String,
    val category: String
)