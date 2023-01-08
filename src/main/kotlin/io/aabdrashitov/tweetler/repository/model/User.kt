package io.aabdrashitov.tweetler.repository.model

data class User(
    val id: Long,
    val username: String,
    val displayName: String,
    val followers: List<User>
)

data class UserIdentity(
    val id: Long
)