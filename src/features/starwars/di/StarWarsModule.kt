package com.selimatasoy.features.starwars.di

import com.selimatasoy.features.starwars.data.StarWarsData
import com.selimatasoy.features.starwars.data.StarWarsDataImpl
import com.selimatasoy.features.starwars.remote.StarWarsRemote
import com.selimatasoy.features.starwars.remote.StarWarsRemoteImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val starWarsModule = module {
    single { StarWarsRemoteImpl(get()) } bind StarWarsRemote::class
    single { StarWarsDataImpl(get()) } bind StarWarsData::class
}