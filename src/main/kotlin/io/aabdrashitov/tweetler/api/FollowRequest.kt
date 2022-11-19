package io.aabdrashitov.tweetler.api

import java.util.UUID

data class FollowRequest(
    val followerId: UUID,
    val leaderId: UUID
)
