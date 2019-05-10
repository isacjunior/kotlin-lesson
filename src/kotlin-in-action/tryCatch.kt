// 2.5.2 try como uma expressão

fun readNumber(read: BufferedReader) {
  val number = try {
    Integer.parseInt(reader.readLine()) // u
  } catch (e: NumberFormatException) {
    return
  }
  println(number)
}

val reader = BufferedReader(StringReader("not a number"))
readNumber(reader) // v

// u Torna-se o valor da expressão
// v Nada é exibido

// 2.19 Devolvendo um valor em catch

fun readNumber(reader: BufferedReader) {
  val number = try {
    Integer.parseInt(reader.readLine())
  } catch (e: NumberFormatException) {
    null
  }
  println(number)
}

val reader = BufferedReader(StringReader("not a number"))
readNumber(reader) // null