package com.selimatasoy.di

import com.selimatasoy.httpclient.HttpService
import com.selimatasoy.httpclient.HttpServiceImpl
import com.selimatasoy.jwt.JwtManager
import com.selimatasoy.jwt.JwtManagerImpl
import com.typesafe.config.ConfigFactory
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val applicationModule = module {
    single { JwtManagerImpl(get(qualifier = named("jwtSecretProperty"))) } bind JwtManager::class
    single<String>(named("jwtSecretProperty")) { ConfigFactory.load().getString("jwt.secret").toString() }
    factory { HttpServiceImpl() } bind HttpService::class
}