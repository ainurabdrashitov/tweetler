package io.aabdrashitov.tweetler

import io.aabdrashitov.tweetler.api.handler.MainHandlerImpl
import io.aabdrashitov.tweetler.repository.PostRepository
import io.aabdrashitov.tweetler.repository.PostRepositoryImpl
import io.aabdrashitov.tweetler.service.DummyPostServiceImpl
import io.aabdrashitov.tweetler.service.PostService
import io.aabdrashitov.tweetler.service.PostServiceImpl

class Dependencies {
    private val dummyModeEnabled: Boolean = true

    val postRepository: PostRepository = PostRepositoryImpl()
    val postService: PostService = if (dummyModeEnabled) DummyPostServiceImpl() else PostServiceImpl(postRepository)

    // request handlers
    val mainHandler = MainHandlerImpl(postService)
}