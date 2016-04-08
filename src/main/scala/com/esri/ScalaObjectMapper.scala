package com.esri

import javax.annotation.PostConstruct

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.stereotype.Component

/**
  * https://github.com/FasterXML/jackson-module-scala
  */
@Component
class ScalaObjectMapper extends ObjectMapper {
  @PostConstruct
  def postConstruct() = {
    registerModule(DefaultScalaModule)
  }
}
