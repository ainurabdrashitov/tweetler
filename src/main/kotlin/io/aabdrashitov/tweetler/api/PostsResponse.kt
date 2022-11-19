package io.aabdrashitov.tweetler.api

import java.time.ZonedDateTime
import java.util.UUID

data class PostsResponse(
    val posts: List<Post>
)

data class Post(
    val id: UUID,
    val message: String,
    val date: ZonedDateTime
)