package com.seon.invoicer

import java.nio.file.Files.newInputStream
import java.nio.file.Paths

import com.seon.invoicer.config.AppConfig
import com.seon.invoicer.model.{Company, CompanyBasic}
import com.seon.invoicer.services.InvoiceService
import play.api.libs.json.Json

object GeneratePdf extends AppConfig {

  def main(args: Array[String]) {

    val daysWorked = args(0).toInt
    val invoiceNumber = args(1).toInt

    val payee = Json.parse(newInputStream(Paths.get(externalPath+"payee.json"))).as[Company]
    val payer = Json.parse(newInputStream(Paths.get(externalPath+"payer.json"))).as[CompanyBasic]

    val service:InvoiceService = new InvoiceService(makePdfName(invoiceNumber), payee, payer)
    service.generatePDF(daysWorked, invoiceNumber)
  }

  def makePdfName(invoiceNumber:Int):String = s"$fileNamePrefix $invoiceNumber$fileNameSuffix"

}
