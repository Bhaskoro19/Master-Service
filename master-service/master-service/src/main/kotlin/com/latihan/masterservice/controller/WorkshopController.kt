package com.latihan.masterservice.controller

import com.latihan.masterservice.domain.constant.ConstantVariable
import com.latihan.masterservice.domain.constant.ExceptionMessage
import com.latihan.masterservice.domain.dto.request.global.AuthDto
import com.latihan.masterservice.domain.dto.request.workshop.ReqCreateWorkshopDto
import com.latihan.masterservice.domain.dto.request.workshop.ReqGetListWorkshopDto
import com.latihan.masterservice.domain.dto.response.global.ResMessageDto
import com.latihan.masterservice.exception.AuthorizationException
import com.latihan.masterservice.service.WorkshopService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

@RestController
@RequestMapping("/rest/v1/workshop/")
class WorkshopController(
        private val workshopService: WorkshopService
) {


    @PostMapping("create")
    fun createWorkshop(@RequestHeader authToken: String, @Valid @RequestBody request: ReqCreateWorkshopDto, servletRequest : HttpServletRequest): ResponseEntity<ResMessageDto> {
        val authDto: AuthDto = servletRequest.getAttribute(ConstantVariable.USER) as AuthDto
        if (!authDto.userCategory.equals(ConstantVariable.USER_CMS)) {
            throw AuthorizationException(ExceptionMessage.USER_IS_NOT_CMS_USER)
        }

        val response = workshopService.createWorkshop(request)
        return ResponseEntity.ok().body(response)
    }

    @PostMapping("list")
    fun getListWorkshopMobile(@RequestHeader authToken: String, @Valid @RequestBody request: ReqGetListWorkshopDto, servletRequest : HttpServletRequest): ResponseEntity<ResMessageDto> {
        val authDto: AuthDto = servletRequest.getAttribute(ConstantVariable.USER) as AuthDto
        if (!authDto.userCategory.equals(ConstantVariable.USER_MOBILE)) {
            throw AuthorizationException(ExceptionMessage.USER_IS_NOT_MOBILE_USER)
        }

        val response = workshopService.getListWorkshopMobile(request)
        return ResponseEntity.ok().body(response)
    }


}