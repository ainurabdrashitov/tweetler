package io.aabdrashitov.tweetler.repository

import io.aabdrashitov.tweetler.repository.model.User
import java.util.*

interface UserRepository {
    fun findById(userId: UUID): User
    fun update(user: User): User
}

class UserRepositoryImpl : UserRepository {
    override fun findById(userId: UUID): User {
        TODO("Not yet implemented")
    }

    override fun update(user: User): User {
        TODO("Not yet implemented")
    }
}