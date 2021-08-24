package com.selimatasoy.features.starwars.remote

import com.selimatasoy.features.starwars.model.Movie

interface StarWarsRemote {
    suspend fun getMovie(): Movie
}