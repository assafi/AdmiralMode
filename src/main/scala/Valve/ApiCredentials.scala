package Valve

import org.json4s._
import org.json4s.native.JsonMethods._
import grizzled.slf4j.Logging
import java.io.File
import scala.io.Source

/*
 * AdmiralMode
 * Author: Assaf Israel
 * Date: 3/26/14
 */
case class ApiCredentials(credentialsJson : String) extends Logging {

  implicit val formats = DefaultFormats

  val jsonFile = new File(ApiCredentials.getClass.getResource(credentialsJson).getFile)
  debug(s"Reading credentials from ${jsonFile.getAbsolutePath}")
  debug(s"File content: ${Source.fromFile(jsonFile).getLines().mkString}")
  val json = parse(Source.fromFile(jsonFile).getLines().mkString)

  val credentials = (json \ "key").extract[String]
  info(s"Using Valve key: $credentials")
}
