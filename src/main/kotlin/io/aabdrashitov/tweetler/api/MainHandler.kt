package io.aabdrashitov.tweetler.api

class MainHandler {

    fun getFeed(request: GetFeedRequest): PostsResponse {
        return PostsResponse(emptyList())
    }

    fun getHome(request: GetHomeRequest): PostsResponse {
        return PostsResponse(emptyList())
    }

    fun post(request: PostRequest): PostResultResponse {
        return PostResultResponse(PostResult.SUCCESS)
    }

    fun follow(request: FollowRequest): FollowResultResponse {
        return FollowResultResponse(FollowResult.SUCCESS)
    }
}