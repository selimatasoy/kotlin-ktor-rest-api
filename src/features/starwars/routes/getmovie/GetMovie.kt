package com.selimatasoy.features.starwars.routes.getmovie

import com.selimatasoy.features.starwars.data.StarWarsData
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.getMovie() {
    val starWarsData: StarWarsData by inject(StarWarsData::class.java)
    get("/api/v1/star-wars/movie") {
        call.respond(starWarsData.getMovie())
    }
}