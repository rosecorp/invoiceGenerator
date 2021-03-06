package com.seon.invoicer.model

import play.api.libs.json.Json
import spray.http.DateTime

case class Company(
                    dailyRate:Int,
                    basicData :CompanyBasic,
                    vatNumber: String,
                    companyRegisteredNumber: String,
                    paymentDetails: PaymentDetails,
                    description: String
                    )

case class CompanyBasic(name: String,
                        address: String,
                        postCode: String)

case class PaymentDetails(
                           bank: String,
                           accountNumber: Int,
                           sortCode: String
                           )
case class Invoice(
                    number: Int,
                    payee: Company,
                    payer: CompanyBasic,
                    daysWorked: Int,
                    amountToPayPerDay: Double,
                    date: DateTime = DateTime.now,
                    percentage: Double = 20
                    ) {

  val vat: Double = amountToPayPerDay * (percentage / 100)
  val totalWithoutVat = amountToPayPerDay * daysWorked
  val totalVat = vat * daysWorked
  val total: Double = totalWithoutVat + totalVat
  val prettyDate: String = s"${date.day}/${date.month}/${date.year}"
}

object Company {
  implicit val companyBasic = Json.format[CompanyBasic]
  implicit val paymentDetails = Json.format[PaymentDetails]
  implicit val company = Json.format[Company]
}
object CompanyBasic {
  implicit val companyBasic = Json.format[CompanyBasic]
  implicit val paymentDetails = Json.format[PaymentDetails]
  implicit val company = Json.format[Company]
}
