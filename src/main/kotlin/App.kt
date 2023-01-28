import dao.DatabaseFactory
import io.ktor.server.application.*
import plugins.configureTemplating
import routing.configureRouting

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    DatabaseFactory.init(environment.config)
    configureTemplating()
    configureRouting()
}
