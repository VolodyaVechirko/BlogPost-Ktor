package routing

import dao.PostDao
import dao.PostDaoImpl
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val dao: PostDao = PostDaoImpl()

fun Application.configureRouting() {
    routing {
        static("/static") {
            resources("files")
        }
        get("/") {
            call.respondRedirect("articles")
        }

        route("articles") {
            postView(dao = dao)
        }

        route("api/posts") {
            postApi(dao = dao)
        }
    }
}
