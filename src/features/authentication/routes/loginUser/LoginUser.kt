package com.selimatasoy.features.authentication.routes.loginUser

import com.selimatasoy.features.authentication.data.AuthenticationData
import com.selimatasoy.features.authentication.model.LoginRequestDto
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.loginUser() {
    val authenticationData: AuthenticationData by inject()
    post("/login") {
        val request = call.receive<LoginRequestDto>()
        call.respond(mapOf("token" to authenticationData.login(request)))
    }
}