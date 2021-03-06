package com.seon.invoicer.services

import com.seon.invoicer.config.AppConfig
import com.seon.invoicer.model.{Company, CompanyBasic}
import play.api.libs.json.Json

class CompanyService extends AppConfig {

  private val PayeeFile = "payee.json"
  private val PayerFile = "payer.json"

  def makePayee():Company = {
    Json.parse(loadResource(PayeeFile)).as[Company]
  }
  def makePayer():CompanyBasic = {
    Json.parse(loadResource(PayerFile)).as[CompanyBasic]
  }

}
