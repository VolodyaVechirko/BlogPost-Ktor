package routing

import dao.PostDao
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Route.postView(dao: PostDao) {
    get {
        call.respond(FreeMarkerContent("index.ftl", mapOf("articles" to dao.getAll())))
    }
    get("new") {
        call.respond(FreeMarkerContent("create.ftl", model = null))
    }
    post {
        val formParameters = call.receiveParameters()
        val title = formParameters.getOrFail("title")
        val body = formParameters.getOrFail("body")
        val article = dao.create(title, body)
        call.respondRedirect("/articles/${article?.id}")
    }
    get("{id}") {
        val id = call.parameters.getOrFail<Int>("id")
        call.respond(FreeMarkerContent("show.ftl", mapOf("article" to dao.get(id))))
    }
    get("{id}/edit") {
        val id = call.parameters.getOrFail<Int>("id")
        call.respond(FreeMarkerContent("edit.ftl", mapOf("article" to dao.get(id))))
    }
    post("{id}") {
        val id = call.parameters.getOrFail<Int>("id")
        val param = call.receiveParameters()
        when (param.getOrFail("_action")) {
            "update" -> {
                val title = param.getOrFail("title")
                val body = param.getOrFail("body")
                dao.update(id, title, body)
                call.respondRedirect("/articles/$id")
            }

            "delete" -> {
                dao.delete(id)
                call.respondRedirect("/articles")
            }
        }
    }
}
