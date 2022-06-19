package com.selimatasoy.extensions

import com.typesafe.config.ConfigFactory
import org.jetbrains.exposed.sql.Database

fun Database.Companion.connectToExampleDatabase() {
    val conf = ConfigFactory.load()
    connect(
        url = conf.getString("database.exampleDatabaseUrl"),
        driver = conf.getString("database.exampleDatabaseDriver"),
        user = conf.getString("database.exampleDatabaseUser"),
        password = conf.getString("database.exampleDatabasePassword")
    )
}