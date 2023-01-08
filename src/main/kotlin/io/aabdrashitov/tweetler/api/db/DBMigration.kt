package io.aabdrashitov.tweetler.api.db

import liquibase.Liquibase
import liquibase.database.jvm.JdbcConnection
import liquibase.resource.ClassLoaderResourceAccessor
import javax.sql.DataSource

class DBMigration(private val dataSource: DataSource) {
  fun migrate() {
    dataSource.connection.use {
      // TODO: fill changesets
      Liquibase(
        "db/changesets.xml",
        ClassLoaderResourceAccessor(Thread.currentThread().contextClassLoader),
        JdbcConnection(it)
      ).update("")
    }
  }
}