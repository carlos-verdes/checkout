package checkout

package object model {

  implicit class StringCodesFunctions(codes: Seq[String]) {

    def toItem(implicit catalog: Catalog): Seq[Item] = codes.map(catalog.productByCode(_))
  }
}
