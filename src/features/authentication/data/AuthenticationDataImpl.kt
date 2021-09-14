package com.selimatasoy.features.authentication.data

import com.selimatasoy.features.authentication.dao.AuthenticationDao
import com.selimatasoy.features.authentication.model.LoginRequestDto
import com.selimatasoy.features.authentication.model.UserInfoDto
import com.selimatasoy.jwt.JwtManager

class AuthenticationDataImpl(private val authenticationDao: AuthenticationDao, private val jwtManager: JwtManager) :
    AuthenticationData {
    override fun login(request: LoginRequestDto): String {
        if (authenticationDao.login(request)) {
            return jwtManager.generateToken(request)
        } else {
            throw Exception("There is no such user")
        }
    }

    override fun getUserInfo(email: String): UserInfoDto {
        return authenticationDao.getUserInfo(email).apply { password = null }
    }

    override fun createUser(userInfoDto: UserInfoDto) {
        return authenticationDao.createUser(userInfoDto)
    }
}