package com.esri

import javax.servlet._
import javax.servlet.http.HttpServletResponse

import org.springframework.stereotype.Component

/**
  * https://en.wikipedia.org/wiki/Cross-origin_resource_sharing
  */
@Component
class CORSFilter extends Filter {

  override def init(filterConfig: FilterConfig): Unit = {}

  override def doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain): Unit = {
    val response = servletResponse.asInstanceOf[HttpServletResponse]
    response.setHeader("Access-Control-Allow-Origin", "*")
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE")
    response.setHeader("Access-Control-Max-Age", "3600")
    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
    filterChain.doFilter(servletRequest, servletResponse)
  }

  override def destroy(): Unit = {}
}
