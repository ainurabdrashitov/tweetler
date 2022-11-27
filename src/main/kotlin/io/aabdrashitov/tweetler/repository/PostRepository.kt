package io.aabdrashitov.tweetler.repository

import io.aabdrashitov.tweetler.repository.model.Post
import java.util.*

interface IPostRepository {
    // select u.*
    // from user_users uu on u.id = uu.followed_user_id
    // inner join posts p on u.followed_user_id = p.author_id
    // where uu.follower_user_id = :userId
    fun findAllFollowedUsersPosts(userId: UUID): List<Post>
    fun findAllByAuthorId(userId: UUID): List<Post>
}

class PostRepositoryImpl : IPostRepository {
    override fun findAllFollowedUsersPosts(userId: UUID): List<Post> {
        TODO("Not yet implemented")
    }

    override fun findAllByAuthorId(userId: UUID): List<Post> {
        TODO("Not yet implemented")
    }
}