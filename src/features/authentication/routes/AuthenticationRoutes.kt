package com.selimatasoy.features.authentication.routes

import com.selimatasoy.features.authentication.routes.createUser.createUser
import com.selimatasoy.features.authentication.routes.loginUser.loginUser
import com.selimatasoy.features.authentication.routes.userInfo.userInfo
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.routing.*

fun Application.authenticationRoutes() {
    routing {
        loginUser()
        authenticate {
            userInfo()
        }
        createUser()
    }
}