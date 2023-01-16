package dao

import dao.DatabaseFactory.dbQuery
import models.Post
import models.Articles
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class PostDaoImpl : PostDao {
    override suspend fun getAll(): List<Post> = dbQuery {
        Articles.selectAll()
            .map { it.toPost() }
    }

    override suspend fun get(id: Int): Post? = dbQuery {
        Articles.select { Articles.id eq id }
            .map { it.toPost() }
            .firstOrNull()
    }

    override suspend fun create(title: String, body: String): Post? = dbQuery {
        Articles.insert {
            it[Articles.title] = title
            it[Articles.body] = body
        }.resultedValues?.firstOrNull()?.toPost()
    }

    override suspend fun update(id: Int, title: String, body: String): Boolean = dbQuery {
        Articles.update({ Articles.id eq id }) {
            it[Articles.title] = title
            it[Articles.body] = body
        } > 0
    }

    override suspend fun delete(id: Int): Boolean = dbQuery {
        Articles.deleteWhere { Articles.id eq id } > 0
    }

    private fun ResultRow.toPost() = Post(
        id = this[Articles.id],
        title = this[Articles.title],
        body = this[Articles.body],
    )
}
