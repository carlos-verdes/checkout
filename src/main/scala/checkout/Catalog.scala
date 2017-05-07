/*
 * TODO: License goes here!
 */

package checkout

import checkout.model.Item

trait Catalog {

  def productByCode(code: String): Item
}

object Catalog {

  val HARDCODED_CATALOG = new Catalog {

    override def productByCode(code: String): Item = {
      code.trim.toLowerCase match {
        case "apple" => Item("Apple", 60)
        case "orange" => Item("Orange", 25)
        case _ => Item.UNKNOWN
      }
    }
  }
}
