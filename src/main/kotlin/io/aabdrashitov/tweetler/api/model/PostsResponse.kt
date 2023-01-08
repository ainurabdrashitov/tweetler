package io.aabdrashitov.tweetler.api.model

import java.time.ZonedDateTime

data class PostsResponse(
    val posts: List<Post>
)

data class Post(
    val id: Long?,
    val text: String,
    val date: ZonedDateTime
)