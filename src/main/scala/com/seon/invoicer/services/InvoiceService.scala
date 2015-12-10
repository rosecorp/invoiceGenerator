package com.seon.invoicer.services

import java.io.File

import com.seon.invoicer.model.{Company, CompanyBasic, Invoice}


class InvoiceService(pdfName:String, payee:Company, payer:CompanyBasic) {

  def generatePDF(daysWorked:Int, invoiceNumber:Int) {

    val invoice = Invoice(invoiceNumber,payee, payer, daysWorked, payee.dailyRate)
    val htmlInvoice = HtmlBuilder.makeHtmlInvoice(invoice)

    PdfBuilder.getSimplePdf.run(htmlInvoice, new File(pdfName))
  }
}
