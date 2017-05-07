/*
 * TODO: License goes here!
 */

package checkout

import checkout.model.Item

class Checkout() {

  def total(items: Seq[Item]): Double = items.map(_.priceInPennies).fold(0d)(_ + _)
}
