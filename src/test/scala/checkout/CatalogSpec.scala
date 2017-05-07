/*
 * TODO: License goes here!
 */

package checkout

import checkout.model.Item
import org.scalatest.{FlatSpec, Matchers}

class CatalogSpec extends FlatSpec with Matchers {

  trait WithCodesAndCatalog {

    implicit val catalog = Catalog.HARDCODED_CATALOG

    val appleText = "apple"
    val orangeText = "orange"
    val apple = Item("Apple", 60)
    val orange = Item("Orange", 25)
    val codeWithUpperCase = appleText.toUpperCase()
    val codeWithSpaces = (" " + appleText + " ")
    val unknownEntries = "kiwi"
  }

  "HARDCODED_CATALOG" should "retrieve apples and oranges by (hardcoded) code" in new WithCodesAndCatalog {
    catalog.productByCode(appleText) should be(apple)
    catalog.productByCode(orangeText) should be(orange)
  }

  it should "not be case sensitive with items codes" in new WithCodesAndCatalog {
    catalog.productByCode(codeWithUpperCase) should be(apple)
  }

  it should "not take into account spaces" in new WithCodesAndCatalog {
    catalog.productByCode(codeWithSpaces) should be(apple)
  }

  it should "filter unknown codes" in new WithCodesAndCatalog {
    catalog.productByCode(unknownEntries) should be(Item.UNKNOWN)
  }
}
