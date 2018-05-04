val firstArg = if(!args.isEmpty) args(0) else ""

val friend =
  firstArg match {
    case "salt" => "pepper"
    case "chips" => "queso"
    case "eggs" => "bacon"
    case _ => "huh?"
  }
println(friend)
