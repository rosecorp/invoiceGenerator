package com.seon.invoicer.services

import io.github.cloudify.scala.spdf.{Pdf, PdfConfig, Portrait}

object PdfBuilder {

  def getSimplePdf:Pdf = {
    Pdf(new PdfConfig {
      orientation := Portrait
      pageSize := "Letter"
      marginTop := "1in"
      marginBottom := "1in"
      marginLeft := "1in"
      marginRight := "1in"
    })
  }
}
