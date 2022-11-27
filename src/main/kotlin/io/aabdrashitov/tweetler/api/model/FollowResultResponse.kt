package io.aabdrashitov.tweetler.api.model

data class FollowResultResponse(
    val result: FollowResult
)

@Suppress("unused")
enum class FollowResult {
    SUCCESS,
    FAILED
}
