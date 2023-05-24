package com.latihan.masterservice.config

import com.latihan.masterservice.domain.dto.request.global.AuthDto
import com.latihan.masterservice.service.AuthServiceRestTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Configuration
class ApiHeaderFilter : OncePerRequestFilter() {
    @Autowired
    val authService: AuthServiceRestTemplate? = null

//    @Throws(ServletException::class)
//    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
//        val path = request.requestURI
//        return "/no-header" == path || "/rest/v1/kode/wilayah" == path || "/rest/v1/faq/mobile/detail" == path || "/rest/v1/faq/mobile/category/list" == path || "/rest/v1/search/mobile/promo" == path || "/rest/v1/promo/mobile/detail" == path || "/rest/v1/news/mobile/list" == path || "/rest/v1/news/mobile/detail" == path || "/rest/v1/news/category/list" == path || "/rest/v1/promo/mobile" == path || "/rest/v1/search" == path || "/rest/v1/vehicle/list/model" == path || "/rest/v1/vehicle/list/type" == path || "/rest/v1/vehicle/jenis-kendaraan" == path || "/rest/v1/vehicle/merk-kendaraan" == path || "/rest/v1/vehicle/list/penggunaan/kendaraan" == path || "/rest/v1/derek/request/detail" == path
//    }

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, filterChain: FilterChain) {
        val request = servletRequest
        val response = servletResponse
        val token = request.getHeader("authToken")
        if (token == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
            return
        }

        val authDto: AuthDto = authService!!.getLogin(token)
        if (authDto == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
            return
        }

        request.setAttribute("User", authDto)
        filterChain.doFilter(servletRequest, servletResponse)
    }
}
