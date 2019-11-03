package domain

import data.repository.SessionsRepository

class GetSessions(private val sessionsRepository: SessionsRepository) {

    suspend operator fun invoke(): List<Session> = sessionsRepository.getAll()
}