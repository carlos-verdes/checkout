/*
 * TODO: License goes here!
 */

package checkout

object CheckoutApp extends App{

  import model._

  implicit val catalog = Catalog.HARDCODED_CATALOG
  val offers = Seq(Offer("Apple", 2, 1), Offer("Orange", 3, 2))
  val checkout = new Checkout()
  val codePadding = 12

  print("""Enter items separated by ",": """)
  val items = scala.io.StdIn.readLine().split(",").toSeq.toItem.withOffers(offers)

  println(items.map(item => s"${item.code.padTo(codePadding, ' ')}:  ${item.priceInPennies}").mkString("\n"))
  println("-------------------------------------")

  val total = checkout.total(items)
  println(s"total        : $total")
}
