package io.aabdrashitov.tweetler.repository.model

import java.time.LocalDateTime

data class Post(
    val id: Long?,
    val text: String,
    val datetime: LocalDateTime,
    val author: UserIdentity
)