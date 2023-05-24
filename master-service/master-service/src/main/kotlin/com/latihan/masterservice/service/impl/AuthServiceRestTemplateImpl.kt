package com.latihan.masterservice.service.impl

import com.latihan.masterservice.domain.dto.request.global.AuthDto
import com.latihan.masterservice.service.AuthServiceRestTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.util.*


@Component
class AuthServiceRestTemplateImpl(
        val restTemplate : RestTemplate = RestTemplateBuilder().build(),
        @Value("\${baseurl.account}") private val url: String,
        ) : AuthServiceRestTemplate {

    val URL_GET_LOGIN = "$url/auth/validate/token"
    override fun getLogin(authToken: String): AuthDto {
        val headers = HttpHeaders()
        headers.set("authToken","Bearer " + authToken)
        headers.setBearerAuth(authToken)

        val entity = HttpEntity<String>(headers)
        return try {
            val responseEntity = restTemplate.exchange(URL_GET_LOGIN,
                    HttpMethod.POST, entity, AuthDto::class.java).body
            val result: AuthDto = responseEntity!!
            result
        }catch (e : Exception){
           return AuthDto(null,null,null,null)
        }
    }

}

