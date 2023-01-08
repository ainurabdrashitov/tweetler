package io.aabdrashitov.tweetler.configuration

class ConnectionPoolConfig(private val config: Config) {
    val name get() = "postgres-db-connection-pool"
    val url get() = config["tweetler.db.url"]
    val user get() = config["tweetler.db.user"]
    val password get() = config["tweetler.db.password"]
    val size get() = config["tweetler.db.poolSize.min"].toInt()..config["tweetler.db.poolSize.max"].toInt()
    val loginTimeoutSec get() = config["tweetler.db.loginTimeoutSec"].toInt()
    val connectTimeoutSec get() = config["tweetler.db.connectTimeoutSec"].toInt()
    val idleTimeoutSec get() = config["tweetler.db.idleTimeoutSec"].toInt()
}