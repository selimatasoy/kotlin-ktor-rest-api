package com.selimatasoy.features.starwars.data

import com.selimatasoy.features.starwars.model.Movie

interface StarWarsData {
    suspend fun getMovie(): Movie
}