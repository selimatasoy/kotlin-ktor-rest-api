package com.selimatasoy.features.authentication.routes.loginUser

import com.selimatasoy.features.authentication.data.AuthenticationData
import com.selimatasoy.features.authentication.model.LoginRequestDto
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.loginUser() {
    val authenticationData: AuthenticationData by inject(AuthenticationData::class.java)
    post("/public-api/v1/authentication/login") {
        val request = call.receive<LoginRequestDto>()
        call.respond(mapOf("token" to authenticationData.login(request)))
    }
}