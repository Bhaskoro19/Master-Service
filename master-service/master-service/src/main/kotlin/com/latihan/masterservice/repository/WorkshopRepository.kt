package com.latihan.masterservice.repository

import com.latihan.masterservice.domain.entity.WorkshopEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface WorkshopRepository: JpaRepository<WorkshopEntity, UUID> {

    @Query(value = "SELECT WE "
                + "FROM WorkshopEntity WE "
                + "WHERE LOWER(WE.name) LIKE LOWER(CONCAT('%',:keySearch,'%')) "
                + "AND WE.active = true "
                + "ORDER BY WE.name ASC")
    fun searchWorkshopByName(@Param("keySearch") keySearch: String?, pageable: Pageable): Page<WorkshopEntity>
}