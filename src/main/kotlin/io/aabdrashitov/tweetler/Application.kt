package io.aabdrashitov.tweetler

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import io.aabdrashitov.tweetler.api.db.DBMigration
import io.aabdrashitov.tweetler.configuration.Config
import io.aabdrashitov.tweetler.configuration.ConnectionPoolConfig
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.text.SimpleDateFormat

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    DBMigration(dependencies.connectionPool.dataSource).migrate()
    install(ContentNegotiation) {
        jackson {
            registerModule(JavaTimeModule())
            dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
        }
    }
    routing {
        post("/get-feed") {
            call.respond(dependencies.mainHandler.getFeed(call.receive()))
        }
        post("/get-home") {
            call.respond(dependencies.mainHandler.getHome(call.receive()))
        }
        post("/create-post") {
            call.respond(dependencies.mainHandler.post(call.receive()))
        }
        post("/follow") {
            call.respond(dependencies.mainHandler.follow(call.receive()))
        }
    }
}

private val config = Config()
private val connectionPoolConfig = ConnectionPoolConfig(config)
private val dependencies = Dependencies(config, connectionPoolConfig)