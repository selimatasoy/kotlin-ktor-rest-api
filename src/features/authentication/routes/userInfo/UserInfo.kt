package com.selimatasoy.features.authentication.routes.userInfo

import com.selimatasoy.extensions.getAuthorizationTokenWithoutBearer
import com.selimatasoy.features.authentication.data.AuthenticationData
import com.selimatasoy.jwt.JwtManager
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.userInfo() {
    val authenticationData: AuthenticationData by inject()
    val jwtManager: JwtManager by inject()
    get("/userInfo") {
        call.respond(authenticationData.getUserInfo(jwtManager.getUsernameFromToken(call.getAuthorizationTokenWithoutBearer())!!))
    }
}