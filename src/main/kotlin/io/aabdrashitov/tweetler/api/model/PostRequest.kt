package io.aabdrashitov.tweetler.api.model

import java.time.ZonedDateTime

data class PostRequest(
    val message: String,
    val date: ZonedDateTime
)
