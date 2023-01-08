package io.aabdrashitov.tweetler.configuration

import com.zaxxer.hikari.HikariDataSource
import org.slf4j.LoggerFactory

class ConnectionPool(connectionPoolConfig: ConnectionPoolConfig) {
    private val logger = LoggerFactory.getLogger(javaClass)

    val dataSource: HikariDataSource = createDataSource(connectionPoolConfig)

    private fun createDataSource(connectionPoolConfig: ConnectionPoolConfig): HikariDataSource {
        logger.info("Creating ${connectionPoolConfig.name} connection pool")
        return HikariDataSource().apply {
            poolName = connectionPoolConfig.name
            jdbcUrl = connectionPoolConfig.url
            username = connectionPoolConfig.user
            password = connectionPoolConfig.password
            driverClassName = org.postgresql.Driver::class.java.name
            isAutoCommit = false
            maxLifetime = 60 * 60 * 1000L
            minimumIdle = connectionPoolConfig.size.first
            maximumPoolSize = connectionPoolConfig.size.last
            loginTimeout = connectionPoolConfig.loginTimeoutSec
            connectionTimeout = connectionPoolConfig.connectTimeoutSec * 1000L
            validationTimeout = connectionPoolConfig.loginTimeoutSec * 1000L
            idleTimeout = connectionPoolConfig.idleTimeoutSec * 1000L
            leakDetectionThreshold = 200_000
        }.also {
            logger.info(connectionPoolConfig.name + " JDBC connection pool created: " + connectionPoolConfig.url)
        }
    }
}