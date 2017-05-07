/*
 * TODO: License goes here!
 */

package checkout

object CheckoutApp extends App{

  import model._

  implicit val catalog = Catalog.HARDCODED_CATALOG
  val checkout = new Checkout()

  print("""Enter items separated by ",": """)
  val items = scala.io.StdIn.readLine().split(",").toSeq.toItem

  println(items.map(item => s"${item.code}: ${item.priceInPennies}").mkString("\n"))
  println("-------------------------------------")

  val total = checkout.total(items)
  println(s"total: $total")
}
