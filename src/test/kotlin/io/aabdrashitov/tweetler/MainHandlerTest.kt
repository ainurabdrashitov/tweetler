package io.aabdrashitov.tweetler

import io.aabdrashitov.tweetler.api.model.*
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import java.time.ZonedDateTime
import java.util.*

class MainHandlerTest : BaseServerTest() {

    @Test
    fun testGetFeed() {
        val request = GetFeedRequest(UUID.randomUUID())
        RestAssured.given()
            .contentType(ContentType.JSON)
            .bodyJson(request)
            .When()
            .post("/get-feed")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body(Matchers.not(Matchers.blankOrNullString()))
    }

    @Test
    fun testGetHome() {
        val request = GetHomeRequest(UUID.randomUUID())
        RestAssured.given()
            .contentType(ContentType.JSON)
            .bodyJson(request)
            .When()
            .post("/get-home")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body(Matchers.not(Matchers.blankOrNullString()))
    }

    @Test
    fun testCreatePost() {
        val request = PostRequest("Test message", ZonedDateTime.now())
        val expected = PostResultResponse(PostResult.SUCCESS)
        RestAssured.given()
            .contentType(ContentType.JSON)
            .bodyJson(request)
            .When()
            .post("/create-post")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body(Matchers.equalTo(mapper.writeValueAsString(expected)))
    }

    @Test
    fun testFollow() {
        val request = FollowRequest(UUID.randomUUID(), UUID.randomUUID())
        val expected = FollowResultResponse(FollowResult.SUCCESS)
        RestAssured.given()
            .contentType(ContentType.JSON)
            .bodyJson(request)
            .When()
            .post("/follow")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body(Matchers.equalTo(mapper.writeValueAsString(expected)))
    }
}