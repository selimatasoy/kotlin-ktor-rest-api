package com.selimatasoy.features.authentication.dao.mapper

import com.selimatasoy.features.authentication.model.UserInfoDto
import org.jetbrains.exposed.sql.ResultRow

interface AuthenticationMapper {
    fun fromUserDaoToUserInfo(resultRow: ResultRow): UserInfoDto
}