/*
 * TODO: License goes here!
 */

package checkout

import checkout.model.Item

trait Catalog {

  def productByCode(code: String): Either[Item, String]
}

object Catalog {

  val HARDCODED_CATALOG = new Catalog {

    override def productByCode(code: String): Either[Item, String] = {
      code.trim.toLowerCase match {
        case "apple" => Left(Item("Apple", 60))
        case "orange" => Left(Item("Orange", 25))
        case _ => Right(code)
      }
    }
  }
}
