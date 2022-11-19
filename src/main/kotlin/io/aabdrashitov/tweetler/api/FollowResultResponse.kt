package io.aabdrashitov.tweetler.api

data class FollowResultResponse(
    val result: FollowResult
)

@Suppress("unused")
enum class FollowResult {
    SUCCESS,
    FAILED
}
