package com.selimatasoy.httpclient

import io.ktor.client.*

interface HttpService {
    fun getClient(): HttpClient
}