package com.selimatasoy.features.authentication.di

import com.selimatasoy.features.authentication.dao.AuthenticationDaoImpl
import com.selimatasoy.features.authentication.dao.AuthenticationDao
import com.selimatasoy.features.authentication.data.AuthenticationDataImpl
import com.selimatasoy.features.authentication.data.AuthenticationData
import org.koin.dsl.bind
import org.koin.dsl.module

val authenticationModule = module {
    single { AuthenticationDaoImpl() } bind AuthenticationDao::class
    single { AuthenticationDataImpl(get(),get()) } bind AuthenticationData::class
}