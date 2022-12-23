package io.aabdrashitov.tweetler.api.handler

import io.aabdrashitov.tweetler.api.model.*
import io.aabdrashitov.tweetler.service.PostService
import io.aabdrashitov.tweetler.service.model.User

interface IMainHandler {
    fun getFeed(request: GetFeedRequest): PostsResponse
    fun getHome(request: GetHomeRequest): PostsResponse
    fun post(request: PostRequest): PostResultResponse
    fun follow(request: FollowRequest): FollowResultResponse
}

class MainHandlerImpl(
    private val postService: PostService
) : IMainHandler {

    override fun getFeed(request: GetFeedRequest): PostsResponse {
        return PostsResponse(postService.feed(request.userId))
    }

    override fun getHome(request: GetHomeRequest): PostsResponse {
        return PostsResponse(postService.home(request.userId))
    }

    override fun post(request: PostRequest): PostResultResponse {
        postService.create(
            post = Post(
                id = null,
                text = request.message,
                date = request.date
            ),
            currentUser = User(id = request.authorId)
        )
        // TODO error handler?
        return PostResultResponse(PostResult.SUCCESS)
    }

    override fun follow(request: FollowRequest): FollowResultResponse {
        return FollowResultResponse(FollowResult.SUCCESS)
    }
}