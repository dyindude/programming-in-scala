abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object Expr {
  def main {
    val v = Var("x")
    assert(v.name == "x")

    val op = BinOp("+", Number(1), v)
    assert(op.right == Var("x"))

  }
}
