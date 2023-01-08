package io.aabdrashitov.tweetler.api.model

data class FollowRequest(
    val followerUserId: Long,
    val followedUserId: Long
)
