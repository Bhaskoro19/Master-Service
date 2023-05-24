package com.latihan.masterservice.domain.dto.response.global

import com.fasterxml.jackson.annotation.JsonInclude

data class ResMessageDto(
        val status: Int,

        val message: String,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        var data: List<*>?,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        var totalData: Long? = null
        )
