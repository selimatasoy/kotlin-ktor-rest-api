package com.selimatasoy.features.authentication.dao

import com.selimatasoy.features.authentication.model.LoginRequestDto
import com.selimatasoy.features.authentication.model.UserInfoDto

interface AuthenticationDao {
    fun login(request: LoginRequestDto): Boolean
    fun getUserInfo(email:String): UserInfoDto
    fun createUser(userInfoDto: UserInfoDto)
}