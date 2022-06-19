package com.selimatasoy.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.selimatasoy.features.authentication.model.LoginRequestDto
import org.koin.core.component.KoinComponent
import java.util.*


class JwtManagerImpl(secret: String) : JwtManager, KoinComponent {
    private val validityInMs = 36_000_00 * 1
    private val algorithm = Algorithm.HMAC256(secret)

    override fun getVerifier(): JWTVerifier = JWT.require(algorithm).build()

    override fun generateToken(loginRequestDto: LoginRequestDto): String = JWT.create()
        .withSubject("Authentication")
        .withClaim("email", loginRequestDto.email)
        .withExpiresAt(getExpiration())
        .sign(algorithm)

    override fun getExpiration() = Date(System.currentTimeMillis() + validityInMs)

    override fun getUsernameFromToken(token: String?): String? {
        return JWT.decode(token).getClaim("email").toString().replace("\"", "")
    }

}