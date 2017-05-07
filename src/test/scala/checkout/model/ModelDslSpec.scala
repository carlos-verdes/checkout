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

  "StringCodesFunctions" should "transform text into items" in new WithItemsAndCatalog {

    itemsText.toItem should contain theSameElementsAs(items)
  }
}
