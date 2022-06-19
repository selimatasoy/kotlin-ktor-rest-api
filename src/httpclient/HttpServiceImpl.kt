package com.selimatasoy.httpclient

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import java.text.DateFormat

class HttpServiceImpl : HttpService {

    private val client: HttpClient = HttpClient(OkHttp) {
        engine {
            config {
                followRedirects(true)
            }
        }

        install(ContentNegotiation) {
            gson {
                setPrettyPrinting()
                setDateFormat(DateFormat.LONG)
            }
        }

        install(HttpTimeout) {
            connectTimeoutMillis = 30000
            socketTimeoutMillis = 30000
            requestTimeoutMillis = 30000
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            header(HttpHeaders.AcceptCharset, Charsets.UTF_8)
            header(HttpHeaders.Accept, ContentType.Application.Any)
        }
        HttpResponseValidator {
            handleResponseException { exception ->
                val clientException =
                    exception as? ClientRequestException ?: return@handleResponseException
                val exceptionResponse = exception.response
                val statusCode = exceptionResponse.status.value
                if (exceptionResponse.status != HttpStatusCode.OK) {
                    throw IllegalStateException("error")
                }
            }
        }
    }

    override fun getClient(): HttpClient {
        return client
    }
}
