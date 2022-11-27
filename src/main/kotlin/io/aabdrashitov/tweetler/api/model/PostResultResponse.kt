package io.aabdrashitov.tweetler.api.model

data class PostResultResponse(
    val result: PostResult
)

@Suppress("unused")
enum class PostResult {
    SUCCESS,
    FAILED
}