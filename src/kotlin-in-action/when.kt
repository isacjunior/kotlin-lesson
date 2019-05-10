// Usando when para escolher o valor correto do enum

fun getMnemonic(color: Color) = // u
  when(color) { // v
    Color.RED -> "Richard"
    Color.ORANGE -> "Of"
    Color.BLUE -> "Battle"
  }

// u Devolve diretamente uma expressão when
// v Devolve a string correspondente se a cor for igual ã constante do enum

// 2.13 Combinando opções em um ramo de when

fun getWarmth(color: Color) =
  when(color) {
    Color.RED, Color.ORANGE -> "warm"
    Color.GREEN -> "neutral"
    else -> throw Exception("Dirty color")
  }

// 2.3.4 Usando when sem argumentos

fun mixOptmized(c1: Color, c2: Color) = 
  when {
    (c1 == Color.RED && c2 == Color.YELLOW) -> Color.ORANGE
    else -> throw Exception("Dirty color")
  }

// 2.20 Usando when no lugar de if

fun eval(e: Expr): Int =
  if (e is Num) {
    e.value
  } else if (e is Sum) {
    eval(e.rigth) + eval(e.left)
  } else {
    throw IllegalArgumentException("Unknown expression")
  }

fun eval(e: Expr): Int = 
  when (e) {
    is Num -> e.value
    is Sum -> eval(e.rigth) + eval(e.left)
    else -> throw IllegalArgmentException("Unknown expression")
  }

// 2.21 Usando when com ações compostas

fun evalWithlogging(e: Expr) : Int =
  when(e) {
    is Num -> {
      println("num: ${e.value}")
      e.value // retorno
    }
    is Sum -> {
      val left = evalWithlogging(e.left)
      val rigth = evalWithlogging(e.rigth)
      println("sum: ${left + right}")
      left + right // retorno
    }
    else -> throw IllegalArgmentException("Unknown expression")
  }