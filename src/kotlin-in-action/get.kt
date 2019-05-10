// Métodos de acesso personalizados

class Rectangle(val height: Int, val width: Int) {
  val isSquare: Boolean
    get() {
      return height == width
    }
}

// get personalizado inline
class Rectangle(val height: Int, val width: Int) {
  val isSquare: Boolean
    get() height == width
}