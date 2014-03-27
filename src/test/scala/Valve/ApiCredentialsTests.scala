package Valve

import org.scalatest._
import grizzled.slf4j.Logging

/*
 * AdmiralMode
 * Author: Assaf Israel
 * Date: 3/26/14
 */
class ApiCredentialsTests extends FlatSpec with Matchers with Logging {
  "Api credentials" should "be able to read key from a json file" in {
    val credentials = new ApiCredentials("../test_credentials.json")
    credentials.credentials should be ("ABC")
  }
}
