package io.aabdrashitov.tweetler.api

import java.time.ZonedDateTime

data class PostRequest(
    val message: String,
    val date: ZonedDateTime
)
