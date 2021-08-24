package com.selimatasoy.features.starwars.data

import com.selimatasoy.features.starwars.model.Movie
import com.selimatasoy.features.starwars.remote.StarWarsRemote

class StarWarsDataImpl(private val remote: StarWarsRemote) : StarWarsData {
    override suspend fun getMovie(): Movie {
        return remote.getMovie()
    }
}