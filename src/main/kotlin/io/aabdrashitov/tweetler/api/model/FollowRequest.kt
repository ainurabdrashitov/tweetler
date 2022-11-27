package io.aabdrashitov.tweetler.api.model

import java.util.UUID

data class FollowRequest(
    val followerUserId: UUID,
    val followedUserId: UUID
)
