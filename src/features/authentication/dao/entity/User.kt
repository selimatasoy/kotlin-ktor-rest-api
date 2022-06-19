package com.selimatasoy.features.authentication.dao.entity

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

object User : Table("user") {
    val id = long("id").autoIncrement().uniqueIndex()
    val name = varchar("Name", 50)
    val surname = varchar("Surname", 50)
    val birthDate = date("birth_date")
    val email = varchar("Email", 50)
    val password = varchar("Password",20)

    override val primaryKey = PrimaryKey(id, email)
}