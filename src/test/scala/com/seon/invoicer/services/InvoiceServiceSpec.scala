package com.seon.invoicer.services

import org.specs2.mutable.Specification

class InvoiceServiceSpec extends Specification {

  val service = new CompanyService

  "company service" should {
    "load json documents from classpath location" in {
      service.makePayee().description === "Software Development"
    }
  }
}
