package com.selimatasoy.features.authentication.routes.createUser

import com.selimatasoy.features.authentication.data.AuthenticationData
import com.selimatasoy.features.authentication.model.UserInfoDto
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.createUser() {
    val authenticationData: AuthenticationData by inject()
    post("/createUser/") {
        authenticationData.createUser(call.receive<UserInfoDto>())
        call.respond(HttpStatusCode.OK)
    }
}