package com.selimatasoy.features.starwars.remote

import com.selimatasoy.features.starwars.model.Movie
import com.selimatasoy.httpclient.HttpServiceImpl
import io.ktor.client.call.*
import io.ktor.client.request.*

class StarWarsRemoteImpl(private val httpService: HttpServiceImpl) : StarWarsRemote {
    override suspend fun getMovie(): Movie {
        return httpService.getClient().get("https://swapi.dev/api/films/1/").body()
    }
}