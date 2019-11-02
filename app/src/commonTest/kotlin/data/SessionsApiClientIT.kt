package data

import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class SessionsApiClientIT {

    private val httpClientEngineMock = MockEngine.create {
        addHandler { requestData ->
            when (requestData.url.toString()) {
                "https://www.sessionize.com/sessions" -> respond(SESSIONS)
                else -> respond("")
            }
        }
    }

    private val json = Json(JsonConfiguration.Stable.copy(strictMode = false))

    private val sut = SessionsApiClient(
        httpClientEngine = httpClientEngineMock,
        json = json
    )

    @Test
    fun `getSessions happy case`() = runBlocking {
        val sessions = sut.getSessions()

        assertEquals(expectedSessionGroups(), sessions)
    }

    private fun expectedSessionGroups(): List<SessionGroupDto> = listOf(
        SessionGroupDto(
            groupId = 10663,
            groupName = "Technical",
            sessions = listOf(
                SessionDto(
                    id = "14022",
                    title = "Aiden's Session",
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
                    title = "Lucas's Session",
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
                    title = "Mia's Session",
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
                    title = "Jackson's Session",
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