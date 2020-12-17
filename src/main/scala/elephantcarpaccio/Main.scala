package elephantcarpaccio

import java.util.Scanner

object Main {

  def main(args: Array[String]): Unit = {

    val scanner = new java.util.Scanner(System.in)

    val quantity = getItemQuantity(scanner)
    val price = getItemPrice(scanner)
    val stateCode = getStateCode(scanner)

    val totalPrice = getTotalPrice(quantity, price)
    println(s"Total price: $totalPrice")

    val priceWithTax = getTotalPriceWithTax(totalPrice, stateCode)
    println(s"Total price with tax: $priceWithTax")

    val priceWithDiscount = getTotalPriceWithDiscount(priceWithTax)
    println(s"Total price with discount: $priceWithDiscount")

  }

    def getItemQuantity(scanner: Scanner): Int = {
      println("What is the quantity of the item?")
      scanner.nextLine().toInt
    }

    def getItemPrice(scanner: Scanner): Double = {
      println("What is the price of the item?")
      scanner.nextLine().toDouble
    }

    def getStateCode(scanner: Scanner): String = {
      println("What is your state code?")
      scanner.nextLine()
    }

  def getTotalPrice(quantity: Int, price: Double): Double = {
    price * quantity
  }

  def getTotalPriceWithTax(total: Double, stateCode: String): Double = {
    stateCode match {
      case "AL" => total + 0.04 * total
      case "UT" => total + 0.0685 * total
      case "NV" => total + 0.08 * total
      case "TX" => total + 0.0625 * total
      case "CA" => total + 0.0825 * total
    }
  }

  def getTotalPriceWithDiscount(total: Double): Double = {
    total match {
      case total: Double if total >= 1000 => total - 0.03 * total
      case total: Double if total >= 5000 => total - 0.05 * total
      case total: Double if total >= 7000 => total - 0.07 * total
      case total: Double if total >= 10000 => total - 0.10 * total
      case total: Double if total >= 50000 => total - 0.15 * total
    }
  }
}
