package com.latihan.masterservice.domain.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "mst_workshops")
data class WorkshopEntity(
        @field:Id
        @field:GeneratedValue(generator = "UUID")
        @field:GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @field:Type(type = "org.hibernate.type.UUIDCharType")
        @field:Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
        val uuid: UUID,

        @Column(name = "name", length = 200, nullable = false)
        val name : String,

        @Column(name = "address", length = 200, nullable = false)
        val address : String,

        @field:CreationTimestamp
        @field:Column(name = "created_at", updatable = false)
        val createdDate: Timestamp? = null,


        @field:UpdateTimestamp
        @field:Column(name = "updated_at")
        val lastModifiedDate: Timestamp? = null,

        @field:Column(name = "is_active")
        val active: Boolean,



        )
