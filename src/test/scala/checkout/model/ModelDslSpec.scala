/*
 * TODO: License goes here!
 */

package checkout.model

import checkout.Catalog
import org.scalatest.{FlatSpec, Matchers}

class ModelDslSpec extends FlatSpec with Matchers {

  import checkout.model._

  trait WithItemsAndCatalog {

    implicit val catalog = Catalog.HARDCODED_CATALOG

    val itemsText = Seq("apple", "orange")
    val items = Seq(Item("Apple", 60), Item("Orange", 25))
  }

  trait WithItemsAndOffers {

    val apple = Item("apple", 60)
    val orange = Item("orange", 25)
    val items = Seq(apple, orange, apple, orange, orange)
    val offers = Seq(Offer("apple", 2, 1), Offer("orange", 3, 2))
    val itemsWithOffer = Seq(apple, orange, Item("apple 2 x 1", 0d), orange, Item("orange 3 x 2", 0d))
  }

  "StringCodesFunctions" should "transform text into items" in new WithItemsAndCatalog {

    itemsText.toItem should contain theSameElementsAs(items)
  }

  "ItemsFunctions" should "apply offers X for Y" in new WithItemsAndOffers {
    items.withOffers(offers) should contain theSameElementsAs(itemsWithOffer)
  }
}
