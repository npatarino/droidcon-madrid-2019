package data.network

class FakeSessionsApiClient : SessionsApiClient {
    override suspend fun getSessions(): List<SessionGroupDto> = listOf(
        SessionGroupDto(
            groupId = 10663,
            groupName = "Technical",
            sessions = listOf(
                SessionDto(
                    id = "14022",
                    title = "Aiden's SessionData",
                    description = "Usually, you would find a session description here. But, this is not a real session submission, so description is missing. Ha!",
                    startsAt = "2017-05-27T09:00:00Z",
                    endsAt = "2017-05-27T10:00:00Z",
                    isServiceSession = false,
                    isPlenumSession = true,
                    speakers = listOf(
                        SpeakerDto(
                            id = "00000000-0000-0000-0000-000000000004",
                            name = "Aiden Test"
                        )
                    ),
                    room = "Green Room",
                    roomId = 215
                ),
                SessionDto(
                    id = "14023",
                    title = "Lucas's SessionData",
                    description = "Usually, you would find a session description here. But, this is not a real session submission, so description is missing. Ha!",
                    startsAt = "2017-05-27T11:30:00Z",
                    endsAt = "2017-05-27T12:30:00Z",
                    isServiceSession = false,
                    isPlenumSession = false,
                    speakers = listOf(
                        SpeakerDto(
                            id = "00000000-0000-0000-0000-000000000005",
                            name = "Lucas Test"
                        )
                    ),
                    room = "Yellow Room",
                    roomId = 216
                ),
                SessionDto(
                    id = "14027",
                    title = "Mia's SessionData",
                    description = "Usually, you would find a session description here. But, this is not a real session submission, so description is missing. Ha!",
                    startsAt = "2017-05-28T09:00:00Z",
                    endsAt = "2017-05-28T10:00:00Z",
                    isServiceSession = false,
                    isPlenumSession = false,
                    speakers = listOf(
                        SpeakerDto(
                            id = "00000000-0000-0000-0000-000000000009",
                            name = "Mia Test"
                        )
                    ),
                    room = "Green Room",
                    roomId = 215
                )
            )
        ),
        SessionGroupDto(
            groupId = 4375,
            groupName = "Business",
            sessions = listOf(
                SessionDto(
                    id = "14019",
                    title = "Jackson's SessionData",
                    description = "Usually, you would find a session description here. But, this is not a real session submission, so description is missing. Ha!",
                    startsAt = "2017-05-27T10:15:00Z",
                    endsAt = "2017-05-27T11:15:00Z",
                    isServiceSession = false,
                    isPlenumSession = false,
                    speakers = listOf(
                        SpeakerDto(
                            id = "00000000-0000-0000-0000-000000000001",
                            name = "Jackson Test"
                        )
                    ),
                    room = "Yellow Room",
                    roomId = 216
                )
            )
        )
    )
}