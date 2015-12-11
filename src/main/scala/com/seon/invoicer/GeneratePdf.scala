package com.seon.invoicer

import java.nio.file.Files.newInputStream
import java.nio.file.Paths

import com.seon.invoicer.model.{Company, CompanyBasic}
import com.seon.invoicer.services.InvoiceService
import com.typesafe.config.{Config, ConfigFactory}
import play.api.libs.json.Json

import scala.io.Source._

object GeneratePdf {

  val externalPath = "/Users/sebastianonorati/Documents/invoicer/details/"

  def main(args: Array[String]) {
    val daysWorked = args(0).toInt
    val invoiceNumber = args(1).toInt

    val payee = Json.parse(newInputStream(Paths.get(externalPath+"payee.json"))).as[Company]
    val payer = Json.parse(newInputStream(Paths.get(externalPath+"payer.json"))).as[CompanyBasic]

    val service:InvoiceService = new InvoiceService(makePdfName(invoiceNumber), payee, payer)
    service.generatePDF(daysWorked, invoiceNumber)
  }

  def conifg: Config = {
    System.out.print(s"External config location: $externalPath")
    ConfigFactory.parseString(fromFile(externalPath+"pdf-details.properties").mkString)
  }

  def makePdfName(invoiceNumber:Int):String = {
    val prefix = conifg.getString("pdf.name.prefix")
    val suffix = conifg.getString("pdf.name.suffix")
    s"$prefix $invoiceNumber$suffix"
  }

}
