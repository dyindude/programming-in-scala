object OptionType {
  val capitals =
    Map("France" -> "Paris",
        "Japan" -> "Tokyo")
  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }

  def main {
    assert(show(capitals get "Japan") == "Tokyo")
    assert(show(capitals get "France") == "Paris")
    assert(show(capitals get "North Pole") == "?")
  }
}
