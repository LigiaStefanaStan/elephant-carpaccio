package elephantcarpaccio

import elephantcarpaccio.Main._
import org.scalatest._

class MainSpec extends FunSuite with Matchers {

  test("Get the right total back") {
    val testPrice = 1.0
    val testQuantity = 2
    val expected = 2.0
    val actual = getTotalPrice(testQuantity, testPrice)

    actual shouldBe expected
  }

  test("Get the right total with tax back") {
    val testPrice = 1.0
    val testTaxCode = "AL"
    val expected = 1.04
    val actual = getTotalPriceWithTax(testPrice, testTaxCode)

    actual shouldBe expected
  }

  test("Get the right total with discount back") {
    val testPrice = 1000
    val expected = 970.0
    val actual = getTotalPriceWithDiscount(testPrice)

    actual shouldBe expected
  }
}

