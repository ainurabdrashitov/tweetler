package io.aabdrashitov.tweetler.repository.model

import java.util.*

data class User(
    val id: UUID,
    val username: String,
    val displayName: String,
    val followers: List<User>
)