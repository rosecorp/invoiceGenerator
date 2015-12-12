package com.seon.invoicer.config

import com.typesafe.config.{Config, ConfigFactory}

import scala.io.Source._

trait AppConfig {

  val externalPath = "/Users/sebastianonorati/Documents/invoicer/details/"

  val fileNamePrefix = config.getString("pdf.name.prefix")
  val fileNameSuffix = config.getString("pdf.name.suffix")

  def config: Config = {
    System.out.print(s"External config location: $externalPath")
    ConfigFactory.parseString(fromFile(externalPath+"pdf-details.properties").mkString)
  }
}
