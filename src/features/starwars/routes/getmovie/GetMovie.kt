package com.selimatasoy.features.starwars.routes.getmovie

import com.selimatasoy.features.starwars.data.StarWarsData
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.getMovie() {
    val starWarsData: StarWarsData by inject()
    get("/api/v1/star-wars/movie") {
        call.respond(starWarsData.getMovie())
    }
}