package models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Post(val id: Int, val title: String, val body: String) {

    val subtitle: String = "Title description"
    val date: String = "April 7, 2023"

    val coverImage: String = if (id % 2 == 0) {
        "/static/post_woods.jpeg"
    } else {
        "/static/post_bridge.jpeg"
    }
}

object Articles : Table() {
    val id = integer("id").autoIncrement()
    val title = varchar("title", 128)
    val body = varchar("body", 1024)

    override val primaryKey = PrimaryKey(id)
}
