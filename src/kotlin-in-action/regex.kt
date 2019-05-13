// 3.5.2 Expressões regulares e string com aspas triplas

val path = "/User/yole/kotlin-book/chapter.adoc"

// 3.9 Usando extensões de `String` para parsing de paths

data class Path(directory: String, fileName: String, extension: String)

fun parsePath(path: String): Path {
  val directory = path.substringBeforeLast("/")
  val fullName = path.substringAfterLast("/")
  val fileName = fullName.substringBeforeLast(".")
  val extension = fullName.substringAfterLast(".")
  return Path(directory, fileName, extension)
}

>>> val (directory, fileName, extension) = parsePath(path)
>>> println(directory) // /User/yole/kotlin-book
>>> println(fileName) // chapter
>>> println(extension) // adoc

// 3.10 Usando expressões regulares para parse de paths

fun parsePathRegex(path: String): MatchResult.Destructured {
  val regex = """(.+)/(.+)\.(.+)""".toRegex()
  val matchResult = regex.matchEntire(path)
  return matchResult!!.destructured 
}

>>> val (directory, fileName, extension) = parsePathRegex(path)
>>> println(directory) // /User/yole/kotlin-book
>>> println(fileName) // chapter
>>> println(extension) // adoc

// 3.5.3 Strings multilinha com aspas triplas

val kotlinLogo = """|//
          .|//
          .|/\
"""

>>> println(kotlinLogo.trimMargin(".")) 
/* start

|//
|//
|/\

end */