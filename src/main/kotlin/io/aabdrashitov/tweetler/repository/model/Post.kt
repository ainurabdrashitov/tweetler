package io.aabdrashitov.tweetler.repository.model

import java.time.LocalDateTime
import java.util.*

data class Post(
    val id: UUID?,
    val text: String,
    val date: LocalDateTime,
    val author: UserIdentity
)