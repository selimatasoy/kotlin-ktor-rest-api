package com.selimatasoy.features.healthcheck.routes.gethealthcheck

import com.selimatasoy.features.healthcheck.data.HealthCheckData
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.getHealthCheck() {
    val service: HealthCheckData by inject()
    get("/public-api/v1/healthCheck") {
        call.respond(object {
            val response = service.getHealthCheckStatus()
        })
    }
}