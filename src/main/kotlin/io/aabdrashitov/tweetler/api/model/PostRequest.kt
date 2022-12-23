package io.aabdrashitov.tweetler.api.model

import java.time.ZonedDateTime
import java.util.UUID

data class PostRequest(
    val message: String,
    val date: ZonedDateTime,
    val authorId: UUID
)
