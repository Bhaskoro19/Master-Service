package com.latihan.masterservice.service.impl


import com.latihan.masterservice.domain.constant.ConstantVariable
import com.latihan.masterservice.domain.dto.request.workshop.ReqCreateWorkshopDto
import com.latihan.masterservice.domain.dto.request.workshop.ReqGetListWorkshopDto
import com.latihan.masterservice.domain.dto.response.*
import com.latihan.masterservice.domain.dto.response.global.ResMessageDto
import com.latihan.masterservice.domain.dto.response.workshop.ResGetListBengkelDto
import com.latihan.masterservice.domain.entity.*
import com.latihan.masterservice.repository.*
import com.latihan.masterservice.service.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class WorkshopServiceImpl(
        private val workshopRepository: WorkshopRepository,
): WorkshopService {

    override fun createWorkshop(reqCreateWorkshopDto: ReqCreateWorkshopDto): ResMessageDto {
        val request = WorkshopEntity(
                uuid = UUID.randomUUID(),
                name = reqCreateWorkshopDto.name,
                address = reqCreateWorkshopDto.address,
                active = true
        )
        workshopRepository.save(request)
        return ResMessageDto(HttpStatus.OK.value(), ConstantVariable.SUCCESS_MESSAGE, null)
    }


    override fun getListWorkshopMobile(requestDetail: ReqGetListWorkshopDto): ResMessageDto {
        val pageable: Pageable = PageRequest.of(requestDetail.page - 1, ConstantVariable.DATA_PER_PAGE)
        val pageResult: Page<WorkshopEntity> = workshopRepository.searchWorkshopByName(requestDetail.search, pageable)

        val result: List<ResGetListBengkelDto> = pageResult.stream().map<Any> { c: WorkshopEntity? ->
            val respon = c?.let {
                ResGetListBengkelDto(
                        uuid = it.uuid,
                        name = c.name,
                        address = c.address
                )
            }
            respon

        }.collect(Collectors.toList()) as List<ResGetListBengkelDto>

        return ResMessageDto(HttpStatus.OK.value(),ConstantVariable.SUCCESS_MESSAGE, result,pageResult.totalElements)


    }
}