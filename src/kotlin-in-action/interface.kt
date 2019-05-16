// 3.4 Interfaces em Kotlin

interface Clickable {
  fun click()
}

/*Todas as classes não abstratas que implementam essa interface devem prover uma
implementação desse método. Eis o modo de implementar a interface. */

// 4.2 Implementando uma interface simples

class Button: Clickable {
  override fun click() =  println("I was clicked")
}

fun main() {
    Button().click() // I was clicked
}

// 4.3 Definindo um método com um corpo em uma interface

interface Clickable {
  fun click() // u
  fun showOff() = println("I'm clickable!") // v
}

// u Declaração usual de um método
// v Método com uma implementação default

// 4.4 Definindo outra interface que implementa o mesmo método
// 4.5 Chamando a implementação de um método herdado da interface   

interface Clickable {
  fun showOff() = println("I'm clickable!") // v
}

interface Focusable {
  fun showOff() = println("I'm focusable!")
}

class Button: Clickable, Focusable {
  override fun showOff() = super<Focusable>.showOff()
}

// 4.6 Declarando uma classe aberta com um método aberto

/* Todas as classes, métodos e propriedades no Kotlin possuem o modificador
final como default. Isso evita a classe-base frágil, isso pode acarretar em 
comportamentos inesperados nas subclasses */

open class RichButton: Clickable { // u
  fun disable() {} // v
  open fun animate() {} // w
  override fun click() {} // x
}

// u Essa classe é aberta - outras classes podem herdar dela.
// v Essa função é final - você não pode sobrescrevê-la em uma subclasse.
// w Essa função é aberta - você pode sobrescrevê-la em uma subclasse.
// x Essa função sobrescreve uma função aberta e é aberta também.

// 4.7 Proibindo uma sobrescrita

/* No exemplo acima devemos observar que os métodos abertos herdados da interface
também são abertos */

open class RichButton: Clickable {
  final override fun click() {} // u
}

// u final não é redundante nesse caso porque override sem final implica ser aberto.

// 4.8 Declarando uma classe abstrata

abstract class Animated { // u
  abstract fun animate() // v
  open fun stopAnimating() {} // w
  fun animateTwice() {} // w
}

// u Essa classe é aberta - não podemos criar uma instância dela.
// v Essa função é abstrata - ela não tem uma implementação e deve ser sobrescrita em subsclasses.
// w Funções não abstratas em classes abstratas não são abertas por padrão, mas podem ser marcadas como abertas
