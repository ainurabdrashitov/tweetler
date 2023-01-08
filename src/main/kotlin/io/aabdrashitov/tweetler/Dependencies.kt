package io.aabdrashitov.tweetler

import io.aabdrashitov.tweetler.api.handler.MainHandlerImpl
import io.aabdrashitov.tweetler.configuration.Config
import io.aabdrashitov.tweetler.configuration.ConnectionPool
import io.aabdrashitov.tweetler.configuration.ConnectionPoolConfig
import io.aabdrashitov.tweetler.repository.PostRepository
import io.aabdrashitov.tweetler.repository.PostRepositoryImpl
import io.aabdrashitov.tweetler.service.DummyPostServiceImpl
import io.aabdrashitov.tweetler.service.PostService
import io.aabdrashitov.tweetler.service.PostServiceImpl

class Dependencies(config: Config, connectionPoolConfig: ConnectionPoolConfig) {
    val connectionPool = ConnectionPool(connectionPoolConfig)
    val postRepository: PostRepository = PostRepositoryImpl(connectionPool.dataSource)
    val postService: PostService = if (config.dummyModeEnabled) DummyPostServiceImpl() else PostServiceImpl(postRepository)

    // request handlers
    val mainHandler = MainHandlerImpl(postService)
}