package com.latihan.masterservice.domain.dto.request.workshop

import com.latihan.masterservice.domain.constant.ExceptionMessage
import javax.validation.constraints.NotEmpty

data class ReqCreateWorkshopDto(
        @field:NotEmpty(message = ExceptionMessage.NAME_IS_MISSING)
        val name : String,

        @field:NotEmpty(message = ExceptionMessage.ADDRESS_IS_MISSING)
        val address : String,


        )
