// Import e pacotes

package geometry.shapes // u
import java.util.Random // v

class Rectangle(val height: Int, val width: Int) {
  val isSquare: Boolean
    get() = height == width
}

fun createRandomRectangle(): Rectangle {
  val random = Random()
  return Rectangle(random.nextInt(), random.nextInt())
}

// u Declaração do pacote
// v importa a classe do Java

// Importando a função acima

package other.package
import geometry.shapes.* // u
import geometry.shapes.createRandomRectangle // v

fun main(args: Array<String>) {
  val reactangle = createRandomRectangle()
  println(reactangle.isSquare) // x
}

// u importa todas as declarações do pacote
// v importa somente a declaração da função especificada
// x exibe true de modo extremamente raro