package ui

import domain.Session

fun Session.toUIModel(): SessionModel =
    SessionModel(
        id = id,
        title = title,
        additionalInfo = "1 hour / $room",
        time = "10",
        timePeriod = "PM",
        category = category
    )