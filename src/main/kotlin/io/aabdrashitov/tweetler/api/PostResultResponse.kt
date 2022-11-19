package io.aabdrashitov.tweetler.api

data class PostResultResponse(
    val result: PostResult
)

@Suppress("unused")
enum class PostResult {
    SUCCESS,
    FAILED
}