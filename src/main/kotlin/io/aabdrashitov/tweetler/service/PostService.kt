package io.aabdrashitov.tweetler.service

import io.aabdrashitov.tweetler.api.model.Post
import io.aabdrashitov.tweetler.repository.PostRepository
import io.aabdrashitov.tweetler.repository.model.UserIdentity
import io.aabdrashitov.tweetler.service.model.User
import java.time.ZoneOffset.UTC
import java.time.ZonedDateTime

typealias DbPost = io.aabdrashitov.tweetler.repository.model.Post

interface PostService {
    fun feed(userId: Long): List<Post>
    fun home(userId: Long): List<Post>
    fun create(post: Post, currentUser: User)
}

class DummyPostServiceImpl : PostService {
    override fun feed(userId: Long): List<Post> {
        return listOf(
            Post(
                id = 1,
                text = "Dummy message (external)",
                date = ZonedDateTime.of(
                    2022,
                    12,
                    22,
                    12,
                    30,
                    0,
                    0,
                    UTC
                )
            )
        )
    }

    override fun home(userId: Long): List<Post> {
        return listOf(
            Post(
                id = 2,
                text = "Dummy message (my)",
                date = ZonedDateTime.of(
                    2022,
                    12,
                    21,
                    12,
                    30,
                    0,
                    0,
                    UTC
                )
            )
        )
    }

    override fun create(post: Post, currentUser: User) {}
}

class PostServiceImpl(private val postRepository: PostRepository) : PostService {
    override fun feed(userId: Long): List<Post> {
        return postRepository.findAllFollowedUsersPosts(userId).map {
            Post(
                id = it.id,
                text = it.text,
                date = ZonedDateTime.of(it.datetime, UTC)
            )
        }
    }

    override fun home(userId: Long): List<Post> {
        return postRepository.findAllByAuthorId(userId).map {
            Post(
                id = it.id,
                text = it.text,
                date = ZonedDateTime.of(it.datetime, UTC)
            )
        }
    }

    override fun create(post: Post, currentUser: User) {
        postRepository.create(
            DbPost(
                id = null,
                text = post.text,
                datetime = post.date.toLocalDateTime(), // TODO improve
                author = UserIdentity(id = currentUser.id)
            )
        )
    }
}