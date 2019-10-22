package data

import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import kotlin.test.Test
import kotlin.test.assertEquals

class SessionsApiClientIT {

    private val sut = SessionsApiClient(MockEngine.create {
        addHandler{requestData ->
            when(requestData.url.toString()) {
                else -> respond("")
            }
        }
    })

    @Test
    fun `getSessions happy case`() {
        givenAnySessionsOnServer()

        val sessions = sut.getSessions()

        val expectedSessions = emptyList<SessionDto>()
        assertEquals(expectedSessions, sessions)
    }

    private fun givenAnySessionsOnServer() {

    }

    private fun gdivenAnySessionsOnServer() {

    }
}