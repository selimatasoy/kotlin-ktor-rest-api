package com.selimatasoy.features.healthcheck.di

import com.selimatasoy.features.healthcheck.data.HealthCheckDataImpl
import com.selimatasoy.features.healthcheck.data.HealthCheckData
import org.koin.dsl.bind
import org.koin.dsl.module

val healthCheckModule = module {
    single { HealthCheckDataImpl() } bind HealthCheckData::class
}