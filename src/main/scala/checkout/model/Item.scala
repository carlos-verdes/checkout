/*
 * TODO: License goes here!
 */

package checkout.model

case class Item(code: String = "Apple", priceInPennies: Double)

object Item {

  val UNKNOWN = new Item("UNKNOWN", 0d)
}

