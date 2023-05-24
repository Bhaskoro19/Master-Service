package com.latihan.masterservice.service

import com.latihan.masterservice.domain.dto.request.workshop.*
import com.latihan.masterservice.domain.dto.response.global.ResMessageDto

interface WorkshopService {
    fun createWorkshop(reqCreateWorkshopDto: ReqCreateWorkshopDto): ResMessageDto

    fun getListWorkshopMobile(requestDetail: ReqGetListWorkshopDto): ResMessageDto
}