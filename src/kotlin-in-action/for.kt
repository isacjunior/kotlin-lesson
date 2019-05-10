// 2.22 Usando when para implementar o jogo Fizz-Buzz

fun fizBuzz(i: Int) = when {
  i % 15 == 0 -> "FizzBuzz" // u
  i % 3 == 0 -> "Fizz"
  i % 5 == 0 -> "Buzz"
  else -> "$i" // v 
}

for (i in 1..100) { // x
  println(fizBuzz(i))
}

// u Se for divisível por 15, devolve FizzBuzz.
// v Caso contrário, devolve o próprio número.
// x itera sobre o intervalo de inteiros de 1 a 100
/
// 2.23 Iterando por um intervalo com um passo

for(i in 100 downTo 1 step 2) {
  println(fizBuzz(i))
}

// 2.24 Iterando por um mapa

val binaryReps = HashMap<Char, String>()

for (letter in 'A'..'F') {
  binaryReps[letter] = Integer.toBinaryString(letter.toInt())
}

for((letter, binary) in binaryReps) {
  println("$letter = $binary")
}