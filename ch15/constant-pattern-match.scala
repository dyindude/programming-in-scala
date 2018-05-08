object Describe {
  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "empty list"
    case _ => "something else"
  }

  def main {
    assert(describe(5) == "five")
    assert(describe(true) == "truth")
    assert(describe("hello") == "hi!")
    assert(describe(Nil) == "empty list")
    assert(describe("foo bar") == "something else")
  }
}
