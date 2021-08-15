package com.selimatasoy.features.authentication.data

import com.selimatasoy.features.authentication.model.LoginRequestDto
import com.selimatasoy.features.authentication.model.UserInfoDto

interface AuthenticationData {
    fun login(request: LoginRequestDto): String
    fun getUserInfo(email:String): UserInfoDto
    fun createUser(userInfoDto: UserInfoDto)
}