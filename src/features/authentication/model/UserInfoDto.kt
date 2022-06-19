package com.selimatasoy.features.authentication.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class UserInfoDto(
    val name: String,
    val surname: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy") val birthDate: LocalDate,
    val email: String,
    val id: Long? = null,
    var password: String? = null,
)