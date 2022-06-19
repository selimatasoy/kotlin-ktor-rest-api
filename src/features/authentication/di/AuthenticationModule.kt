package com.selimatasoy.features.authentication.di

import com.selimatasoy.features.authentication.dao.AuthenticationDao
import com.selimatasoy.features.authentication.dao.AuthenticationDaoImpl
import com.selimatasoy.features.authentication.dao.mapper.AuthenticationMapper
import com.selimatasoy.features.authentication.dao.mapper.AuthenticationMapperImpl
import com.selimatasoy.features.authentication.data.AuthenticationData
import com.selimatasoy.features.authentication.data.AuthenticationDataImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val authenticationModule = module {
    single { AuthenticationDaoImpl(get()) } bind AuthenticationDao::class
    single { AuthenticationDataImpl(get(), get()) } bind AuthenticationData::class
    factory { AuthenticationMapperImpl() } bind AuthenticationMapper::class
}