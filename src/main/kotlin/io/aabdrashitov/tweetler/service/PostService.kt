package io.aabdrashitov.tweetler.service

import io.aabdrashitov.tweetler.api.model.Post
import io.aabdrashitov.tweetler.repository.IPostRepository
import java.time.ZoneOffset.UTC
import java.time.ZonedDateTime
import java.util.*

interface IPostService {
    fun feed(userId: UUID): List<Post>
    fun home(userId: UUID): List<Post>
}

class PostServiceImpl(private val postRepository: IPostRepository) : IPostService {
    override fun feed(userId: UUID): List<Post> {
        return postRepository.findAllFollowedUsersPosts(userId).map {
            Post(
                id = it.id,
                text = it.text,
                date = ZonedDateTime.of(it.date, UTC)
            )
        }
    }

    override fun home(userId: UUID): List<Post> {
        return postRepository.findAllByAuthorId(userId).map {
            Post(
                id = it.id,
                text = it.text,
                date = ZonedDateTime.of(it.date, UTC)
            )
        }
    }
}