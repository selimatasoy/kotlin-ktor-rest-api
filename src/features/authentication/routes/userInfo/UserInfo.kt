package com.selimatasoy.features.authentication.routes.userInfo

import com.selimatasoy.extensions.getAuthorizationTokenWithoutBearer
import com.selimatasoy.features.authentication.data.AuthenticationData
import com.selimatasoy.jwt.JwtManager
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.userInfo() {
    val authenticationData: AuthenticationData by inject(AuthenticationData::class.java)
    val jwtManager: JwtManager by inject(JwtManager::class.java)
    get("/api/v1/authentication/userInfo") {
        call.respond(authenticationData.getUserInfo(jwtManager.getUsernameFromToken(call.getAuthorizationTokenWithoutBearer())!!))
    }
}