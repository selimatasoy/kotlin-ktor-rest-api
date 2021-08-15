package com.selimatasoy.features.healthcheck.routes

import com.selimatasoy.features.healthcheck.data.HealthCheckData
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Application.healthCheckRoutes() {
    routing {
        getHealthCheck()
    }
}

fun Route.getHealthCheck() {
    val service: HealthCheckData by inject()
    get("/healthCheck/") {
        call.respond(object {
            val response = service.getHealthCheckStatus()
        })
    }
}