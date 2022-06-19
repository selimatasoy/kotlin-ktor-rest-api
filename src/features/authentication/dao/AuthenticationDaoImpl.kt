package com.selimatasoy.features.authentication.dao

import com.selimatasoy.extensions.connectToExampleDatabase
import com.selimatasoy.features.authentication.dao.entity.User
import com.selimatasoy.features.authentication.dao.mapper.AuthenticationMapper
import com.selimatasoy.features.authentication.model.LoginRequestDto
import com.selimatasoy.features.authentication.model.UserInfoDto
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class AuthenticationDaoImpl(private val mapper: AuthenticationMapper) : AuthenticationDao {

    override fun login(request: LoginRequestDto): Boolean {
        Database.connectToExampleDatabase()

        val count: Long = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction User.select { User.email eq request.email }.count()
        }
        return count.toInt() == 1
    }

    override fun getUserInfo(email:String): UserInfoDto {
        Database.connectToExampleDatabase()

        val userInfo = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction mapper.fromUserDaoToUserInfo(User.select { User.email eq email }.single())
        }
        return userInfo
    }

    override fun createUser(userInfoDto: UserInfoDto) {
        Database.connectToExampleDatabase()

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(User)
            User.insert {
                it[name] = userInfoDto.name
                it[surname] = userInfoDto.surname
                it[email] = userInfoDto.email
                it[birthDate] = userInfoDto.birthDate
                it[password] = userInfoDto.password!!
            }
        }
    }
}