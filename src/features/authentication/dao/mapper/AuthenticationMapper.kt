package com.selimatasoy.features.authentication.dao.mapper

import com.selimatasoy.features.authentication.dao.entity.User
import com.selimatasoy.features.authentication.model.UserInfoDto
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.fromUserDaoToUserInfo() = UserInfoDto(
    email = this[User.email],
    name = this[User.name],
    surname = this[User.surname],
    password = ""
)