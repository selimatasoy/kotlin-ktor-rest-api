package com.selimatasoy.features.starwars.routes

import com.selimatasoy.features.starwars.routes.getmovie.getMovie
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.routing.*

fun Application.starWarsRoutes() {
    routing {
        authenticate {
            getMovie()
        }
    }
}