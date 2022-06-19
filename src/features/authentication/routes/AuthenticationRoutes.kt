package com.selimatasoy.features.authentication.routes

import com.selimatasoy.features.authentication.routes.createUser.createUser
import com.selimatasoy.features.authentication.routes.loginUser.loginUser
import com.selimatasoy.features.authentication.routes.userInfo.userInfo
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*

fun Application.authenticationRoutes() {
    routing {
        loginUser()
        authenticate {
            userInfo()
        }
        createUser()
    }
}