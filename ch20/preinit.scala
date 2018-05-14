trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)
  val numer = numerArg / g
  val denom = denomArg / g
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
  override def toString = numer + "/" + denom
}
object PreInit {
  def main {
    val x = 2
    assert((
      new {
        val numerArg = 1 * x
        val denomArg = 2 * x
      } with RationalTrait).toString == "1/2")
    object twoThirds extends {
      val numerArg = 2
      val denomArg = 3
    } with RationalTrait
    assert(twoThirds.toString == "2/3")
  }
}
