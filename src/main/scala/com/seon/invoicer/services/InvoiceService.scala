package com.seon.invoicer.services

import com.seon.invoicer.model.{Company, CompanyBasic, Invoice}

import scala.xml.Elem


class InvoiceService(pdfName:String, payee:Company, payer:CompanyBasic) {

  def generatePDF(daysWorked:Int, invoiceNumber:Int) {

    val invoice = Invoice(invoiceNumber,payee, payer, daysWorked, payee.dailyRate)
    val htmlInvoice: Elem = HtmlBuilder.makeHtmlInvoice(invoice)

    PdfBuilder.generatePdf(htmlInvoice, pdfName)
  }
}
