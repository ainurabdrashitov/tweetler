package io.aabdrashitov.tweetler

import io.aabdrashitov.tweetler.api.handler.MainHandlerImpl
import io.aabdrashitov.tweetler.repository.IPostRepository
import io.aabdrashitov.tweetler.repository.PostRepositoryImpl
import io.aabdrashitov.tweetler.service.IPostService
import io.aabdrashitov.tweetler.service.PostServiceImpl

class Dependencies {
    val postRepository: IPostRepository = PostRepositoryImpl()
    val postService: IPostService = PostServiceImpl(postRepository)

    // request handlers
    val mainHandler = MainHandlerImpl(postService)
}