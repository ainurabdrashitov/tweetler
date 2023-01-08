package io.aabdrashitov.tweetler.repository

import io.aabdrashitov.tweetler.repository.model.Post
import javax.sql.DataSource

interface PostRepository {
    // select u.*
    // from user_users uu on u.id = uu.followed_user_id
    // inner join posts p on u.followed_user_id = p.author_id
    // where uu.follower_user_id = :userId
    fun findAllFollowedUsersPosts(userId: Long): List<Post>
    fun findAllByAuthorId(userId: Long): List<Post>
    fun create(post: Post)
}

class PostRepositoryImpl(private val dataSource: DataSource) : PostRepository {
    override fun findAllFollowedUsersPosts(userId: Long): List<Post> {
        TODO("Not yet implemented")
    }

    override fun findAllByAuthorId(userId: Long): List<Post> {
        TODO("Not yet implemented")
    }

    override fun create(post: Post) {
        // TODO: use ORM?
        dataSource.connection.use {
            it.prepareCall("insert into post (id, text, datetime) values (1, '${post.text}', CURRENT_TIMESTAMP);").execute()
            it.commit()
        }
    }
}