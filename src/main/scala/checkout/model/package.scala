package checkout

import scala.annotation.tailrec

package object model {

  implicit class StringCodesFunctions(codes: Seq[String]) {

    def toParsedItem(implicit catalog: Catalog): Seq[Either[Item, String]] = codes.map(catalog.productByCode(_))

    def toItem(implicit catalog: Catalog): Seq[Item] = toParsedItem.collect { case Left(item) => item }
  }

  implicit class ItemsFunctions(val items: Seq[Item]) extends AnyVal {

    def withOffers(offers: Seq[Offer]): Seq[Item] = {
      @tailrec
      def applyOffers(offers: Seq[Offer], items: Seq[Item], offerItems: Seq[Item] = Seq()): Seq[Item] = offers match {
        case offer :: otherOffers =>

          val (itemsWithOffer, otherItems) = items.partition(_.code == offer.code)

          val itemsOfferApplied = itemsWithOffer.sliding(offer.unitsToApply).map(_.splitAt(offer.unitsToCharge)).map {
            case (itemsToCharge, itemsFree) => itemsToCharge ++ itemsFree.map(item =>
              Item(s"${item.code} ${offer.unitsToApply} x ${offer.unitsToCharge}", 0d))
          }.flatMap(_.toSeq).toSeq
          applyOffers(otherOffers, otherItems, offerItems ++ itemsOfferApplied)
        case _ => items ++ offerItems
      }
      applyOffers(offers, items)
    }
  }
}
