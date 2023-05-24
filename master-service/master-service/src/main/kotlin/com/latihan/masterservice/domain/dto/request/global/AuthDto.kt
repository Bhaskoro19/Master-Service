package com.latihan.masterservice.domain.dto.request.global

import java.util.*

data class AuthDto(
        val uuid: UUID?,

        val name: String?,

        val email: String?,

        val userCategory: String?
)
