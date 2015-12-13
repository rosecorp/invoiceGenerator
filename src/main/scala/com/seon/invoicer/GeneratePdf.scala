package com.seon.invoicer

import java.nio.file.{Paths, Files}

import com.seon.invoicer.config.AppConfig
import com.seon.invoicer.services.{CompanyService, InvoiceService}

object GeneratePdf extends AppConfig {

  def main(args: Array[String]) {

    val daysWorked = args(0).toInt
    val invoiceNumber = args(1).toInt

    val company = new CompanyService

    val service = new InvoiceService(makePdfName(invoiceNumber), company.makePayee(), company.makePayer())
    service.generatePDF(daysWorked, invoiceNumber)
  }

  def makePdfName(invoiceNumber:Int):String = {
    if (Files.exists(Paths.get(pdfPath))) s"$pdfPath/$fileNamePrefix$invoiceNumber $fileNameSuffix"
    else s"$fileNamePrefix$invoiceNumber $fileNameSuffix"
  }
}
