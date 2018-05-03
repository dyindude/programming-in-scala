// Returns a row as a sequence
def makeRowSeq(row: Int) =
  for (col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
  }

// Returns a row as a string
def makeRow(row: Int) = makeRowSeq(row).mkString //why couldn't we just pass this?

// Returns table as a string with one row per line
def multiTable() = {
  val tableSeq = // a sequence of row strings
    for (row <- 1 to 10)
      //yield makeRowSeq(row).mkString //also works here, but doesn't demonstrate
                                       //working with multiple functions
      yield makeRow(row)
  tableSeq.mkString("\n")
}

println(multiTable)
