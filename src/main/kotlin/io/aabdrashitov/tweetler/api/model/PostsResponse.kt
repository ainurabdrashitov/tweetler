package io.aabdrashitov.tweetler.api.model

import java.time.ZonedDateTime
import java.util.UUID

data class PostsResponse(
    val posts: List<Post>
)

data class Post(
    val id: UUID,
    val text: String,
    val date: ZonedDateTime
)