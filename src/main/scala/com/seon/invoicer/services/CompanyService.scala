package com.seon.invoicer.services

import java.io.InputStream

import com.seon.invoicer.config.AppConfig
import com.seon.invoicer.model.{Company, CompanyBasic}
import play.api.libs.json.Json

class CompanyService extends AppConfig {

  private val PayeeFile = "payee.json"
  private val PayerFile = "payer.json"

  def makePayee():Company = {
    Json.parse(makePath(PayerFile)).as[Company]
  }
  def makePayer():CompanyBasic = {
    Json.parse(makePath(PayerFile)).as[CompanyBasic]
  }

  private def makePath(file: String):InputStream = {
    val externalStream = getClass.getClassLoader.getResourceAsStream(externalPath+file)
    val localStream = getClass.getClassLoader.getResourceAsStream(file)
    Option(externalStream).getOrElse(localStream)
  }
}
