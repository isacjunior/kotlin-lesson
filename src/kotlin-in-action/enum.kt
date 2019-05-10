// 2.10 Declarando uma classe enum simples

enum class Color {
  RED, ORANGE, YELLOW, GREEN, BLUE
}

// Declarando uma classe enum com propriedades

enum class Color(val r: Int, val g: Int, val b: Int) { // u
  RED(255, 0, 0), ORANGE(255, 165, 0), BLUE(0, 0, 255); // v

  fun rgb() = (r * 256 + g) * 256 + b // x
}

// u declara propriedades de constantes do enum
// v define o valor das propriedades quando cada constante é criada, o uso do ; é necessário
// x define um método na classe enum