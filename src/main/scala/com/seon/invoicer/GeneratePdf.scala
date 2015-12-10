package com.seon.invoicer

import java.util.Properties

import com.seon.invoicer.model.{Company, CompanyBasic}
import com.seon.invoicer.services.InvoiceService
import com.typesafe.config.{Config, ConfigFactory}
import play.api.libs.json.Json

object GeneratePdf {

  def main(args: Array[String]) {
    val daysWorked = args(0).toInt
    val invoiceNumber = args(1).toInt

    val payee = Json.parse(getClass.getClassLoader.getResourceAsStream("payee.json")).as[Company]
    val payer = Json.parse(getClass.getClassLoader.getResourceAsStream("payer.json")).as[CompanyBasic]

    val service:InvoiceService = new InvoiceService(makePdfName(invoiceNumber), payee, payer)
    service.generatePDF(daysWorked, invoiceNumber)
  }

  def makePdfName(invoiceNumber:Int):String = {
    val prefix = config.getString("pdf.name.prefix")
    val suffix = config.getString("pdf.name.suffix")
    s"$prefix $invoiceNumber$suffix"
  }

  def config: Config = {
    val props = new Properties()
    props.load(getClass.getClassLoader.getResourceAsStream("pdf-details.properties"))
    ConfigFactory.parseProperties(props)
  }
}
