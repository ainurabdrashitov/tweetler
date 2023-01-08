package io.aabdrashitov.tweetler.repository

import io.aabdrashitov.tweetler.repository.model.User

interface UserRepository {
    fun findById(userId: Long): User
    fun update(user: User): User
}

class UserRepositoryImpl : UserRepository {
    override fun findById(userId: Long): User {
        TODO("Not yet implemented")
    }

    override fun update(user: User): User {
        TODO("Not yet implemented")
    }
}