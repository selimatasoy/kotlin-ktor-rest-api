package com.selimatasoy.features.healthcheck.routes

import com.selimatasoy.features.healthcheck.routes.gethealthcheck.getHealthCheck
import io.ktor.application.*
import io.ktor.routing.*

fun Application.healthCheckRoutes() {
    routing {
        getHealthCheck()
    }
}