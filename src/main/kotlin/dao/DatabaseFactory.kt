package dao

import io.ktor.server.config.*
import kotlinx.coroutines.Dispatchers
import models.Articles
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File

object DatabaseFactory {
    fun init(config: ApplicationConfig) {
        val driver = config.property("storage.driverName").getString()
        val jdbcURL = config.property("storage.jdbcURL").getString() +
                config.property("storage.dbFilePath").getString().let {
                    File(it).canonicalFile.absolutePath
                }
//        val jdbcURL = config.property("storage.dbFilePath").getString()
        val database = Database.connect(jdbcURL, driver)

        transaction(database) {
            SchemaUtils.create(Articles)
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}
