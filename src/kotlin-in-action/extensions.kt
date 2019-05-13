// 3.3 Funções de extensão e propriedades

package strings

fun String.lastChar(): Char = this.get(this.length - 1)

// `String` é o tipo no qual a extensão é definida
// `this` é a instância desse tipo

>>> println("Kotlin".lastChar()) // n

// Podemos omitir o this e o retorno neste exemplo

fun String.lastChar() = get(length - 1)

// 3.1 Importações e funções de extensão

import strings.lastChar // 1 
import strings.* // 2 
import strings.lastChar as last // 3
val c = "Kotlin".lastChar()

// 3.3.3 Funções utilitárias como extensões

fun <T> Collection<T>.joinToString( // u
  separator: String = ",",
  prefix: String = "",
  postfix: String = ""
): String {
  val result = StringBuilder(prefix)
  for((index, element) in this.withIndex()) { // v
    if(index > 0) result.append(separator)
    result.append(element)
  }
  result.append(postfix)
  return result.toString()
}

val list = listOf(1, 2, 3, 4)
println(list.joinToString()) // "1,2,3,4"

// u Declara a função de extensao em Collection<T>.
// v this refere-se ao objeto receptor - uma coleção de T.

/*
Vamos supor que queiramos obter uma função `join` que possa ser chamada somente
por string.
*/ 

fun Collection<String>.join(
  separator: String = ",",
  prefix: String = "",
  postfix: String = ""
) = joinToString(" ")

// 3.5 Sobrescrevendo uma função-membro

open class View {
  open fun click() = println("View clicked")
}

class Button: View() { // u
  override fun click() = println("Button clicked")
}

// u Button estende de `View`

>>> val view: View = Button()
>>> view.clicked() // u Button clicked

// u Determina o método a ser chamado com base no valor de `view` no momento.

// 3.6 Sem sobrescritas para funções de extensões

fun View.showOff() = println("I`m a view!")
fun Button.showOff() = println("I`m a button!")

>>> val view: View = Button()
>>> view.showOff() // I`m a view!


// 3.7 Declarando uma propriedade de extensão

val String.lastChar: Char
  get() = get(length - 1)

>>> println("Kotlin".lastChar) // n

// 3.8 Declarando uma propriedade de extensão mutável

var StringBuilder.lastChar: Char
  get() = get(length - 1) // u
  set(value: Char) {
    this.setCharAt(length - 1, value) // v
  }

// u Getter da propriedade
// v Setter da propriedade

>>> val sb = StringBuilder("Kotlin?")
>>> sb.lastChar // ?
>>> sb.lastChar = '!'
>>> sb.lastChar // !