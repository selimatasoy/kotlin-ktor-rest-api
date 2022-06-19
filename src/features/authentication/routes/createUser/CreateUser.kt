package com.selimatasoy.features.authentication.routes.createUser

import com.selimatasoy.features.authentication.data.AuthenticationData
import com.selimatasoy.features.authentication.model.UserInfoDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.createUser() {
    val authenticationData: AuthenticationData by inject(AuthenticationData::class.java)
    post("/public-api/v1/authentication/createUser") {
        authenticationData.createUser(call.receive<UserInfoDto>())
        call.respond(HttpStatusCode.OK)
    }
}