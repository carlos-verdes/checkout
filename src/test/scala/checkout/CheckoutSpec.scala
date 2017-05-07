/*
 * TODO: License goes here!
 */

package checkout

import checkout.model.Item
import org.scalatest.{FlatSpec, Matchers}

class CheckoutSpec extends FlatSpec with Matchers {

  trait WithItemsAndCheckout {

    implicit val catalog = Catalog.HARDCODED_CATALOG

    val apple = Item("apple", 60)
    val orange = Item("apple", 25)
    val items = Seq(apple, orange)

    val checkout = new Checkout
  }

  "Checkout" should "calculate the total cost of a sequence of apples and oranges" in new WithItemsAndCheckout {
    checkout.total(items) should be(85)
  }
}
