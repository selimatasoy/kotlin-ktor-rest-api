package com.selimatasoy.jwt

import com.auth0.jwt.JWTVerifier
import com.selimatasoy.features.authentication.model.LoginRequestDto
import java.util.*

interface JwtManager {
    fun generateToken(loginRequestDto: LoginRequestDto): String
    fun getExpiration(): Date
    fun getVerifier(): JWTVerifier
    fun getUsernameFromToken(token: String?): String?
}