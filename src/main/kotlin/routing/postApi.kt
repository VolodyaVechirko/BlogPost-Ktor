package routing

import dao.PostDao
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Route.postApi(dao: PostDao) {
    install(ContentNegotiation) { json() }

    get {
        call.respond(HttpStatusCode.OK, dao.getAll())
    }
    post {
        val param = call.receive<Map<String, String>>()
        val title = param["title"] ?: ""
        val body = param["body"] ?: ""

        if (title.isEmpty()) {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }
        val post = dao.create(title, body)

        if (post != null) {
            call.respond(HttpStatusCode.OK, post)
        } else {
            call.respond(HttpStatusCode.Forbidden)
        }
    }
    get("{id}") {
        val id = call.parameters.getOrFail<Int>("id")
        val post = dao.get(id)

        if (post != null) {
            call.respond(HttpStatusCode.OK, post)
        } else {
            call.respond(HttpStatusCode.NotFound)
        }
    }
    put("{id}") {
        val id = call.parameters.getOrFail<Int>("id")

        val param = call.receive<Map<String, String>>()
        val title = param["title"] ?: ""
        val body = param["body"] ?: ""

        if (title.isEmpty()) {
            call.respond(HttpStatusCode.BadRequest)
            return@put
        }
        dao.update(id, title, body)
        val post = dao.get(id)

        if (post != null) {
            call.respond(HttpStatusCode.OK, post)
        } else {
            call.respond(HttpStatusCode.Conflict)
        }
    }
    delete("{id}") {
        val id = call.parameters.getOrFail<Int>("id")
        dao.delete(id)
        call.respond(HttpStatusCode.OK)
    }
}
