package com.selimatasoy

import com.selimatasoy.features.authentication.routes.authenticationRoutes
import com.selimatasoy.features.healthcheck.routes.healthCheckRoutes
import io.ktor.application.*

fun Application.routes() {
    authenticationRoutes()
    healthCheckRoutes()
}