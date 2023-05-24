package com.latihan.masterservice.service

import com.latihan.masterservice.domain.dto.request.global.AuthDto

interface AuthServiceRestTemplate {
    fun getLogin(authToken: String): AuthDto
}