def echo(args: String*) =
  for (arg <- args) println(arg)

echo("a", "b", "c")
