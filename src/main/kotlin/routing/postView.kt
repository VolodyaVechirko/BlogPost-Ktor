package routing

import dao.PostDao
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import models.pageOwner
import models.postLinks
import models.tagList

val baseData = mutableMapOf(
    "author" to pageOwner,
    "tagList" to tagList,
    "postLinks" to postLinks,
)

fun Route.postView(dao: PostDao) {
    get {
        val data = baseData + ("postList" to dao.getAll())
        call.respond(FreeMarkerContent("index.ftl", model = data))
    }
    get("new") {
        call.respond(FreeMarkerContent("create.ftl", model = baseData))
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
        val data = baseData + ("post" to dao.get(id))
        call.respond(FreeMarkerContent("show.ftl", model = data))
    }
    get("{id}/edit") {
        val id = call.parameters.getOrFail<Int>("id")
        val data = baseData + ("post" to dao.get(id))
        call.respond(FreeMarkerContent("edit.ftl", model = data))
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
