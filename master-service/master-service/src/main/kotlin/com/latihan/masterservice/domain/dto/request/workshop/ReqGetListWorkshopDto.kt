package com.latihan.masterservice.domain.dto.request.workshop

import com.latihan.masterservice.domain.constant.ExceptionMessage
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class ReqGetListWorkshopDto(
        @Positive(message = ExceptionMessage.MIN_REQUIRED_PAGE)
        val page : Int,

        @NotNull(message = ExceptionMessage.SEARCH_FIELD_IS_MISSING)
        var search : String


)
