abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element =
    new ArrayElement(this.contents ++ that.contents)
  def beside(that: Element): Element = {
    new ArrayElement(
      for (
           (line1, line2) <- this.contents zip that.contents
         ) yield line1 + line2
    )
  }
}

class ArrayElement(
  val contents: Array[String]
) extends Element

class LineElement(s: String) extends Element {
  val contents = Array(s)
  override def width = s.length
  override def height = 1
}
