package data.network

import data.repository.SessionData

fun SessionDto.toDataModel(category: String): SessionData =
    SessionData(
        id,
        title,
        description,
        startsAt,
        endsAt,
        isServiceSession,
        isPlenumSession,
        speakers,
        category,
        roomId,
        room
    )