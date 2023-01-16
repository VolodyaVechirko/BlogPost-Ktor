package dao

import models.Post

interface PostDao {
    suspend fun getAll(): List<Post>
    suspend fun get(id: Int): Post?
    suspend fun create(title: String, body: String): Post?
    suspend fun update(id: Int, title: String, body: String): Boolean
    suspend fun delete(id: Int): Boolean
}
