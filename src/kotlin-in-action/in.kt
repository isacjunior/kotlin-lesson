// 2.25 Verificando a pertinência a um intervalo usando in

fun isLetter(letter: Char) = letter in 'a'..'z' || letter in 'A'..'Z'
fun isNotDigit(digit: Char) = digit !in '0'..'9'

println(isLetter('A')) // true
println(isNotDigit('0')) // false

// 2.26 Usando verificação com in em ramos de when

fun recognize(c: Char) = when(c) {
  in '0'..'9' -> "It`s a digit!" // u
  in 'a'..'z', in 'A'..'Z' -> "It`s a letter!" // v
  else -> "I don`t know..."
}

// u Verifica se o valor está no intervalo de 0 a 9
// v Pode combinar vários intervalos

// Bonus
val languages = setOf("Java", "Javascript")
println("Kotlin" in languages) // false