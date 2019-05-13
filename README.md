# Kotlin in action

## Hello World

```kotlin
fun main(args: Array<String>) {
  println("Hello, world!")
}
```

## Import e pacotes

```kotlin
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
```

```kotlin
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
```

## If

```kotlin
/*
Em Kotlin, if não é uma instrução, mas uma expressão.
A diferença entre uma instrução euma expressão é que uma expressão
tem um valor que pode ser usado como parte de outraexpressão,
enquanto uma instrução é sempre um elemento de nível superior no bloco
que acontém, e não tem valor próprio. Em Java, todas as estruturas de
controle são instruções.Em Kotlin, a maioria das estruturas de controle,
exceto os laços (for, do e do/while), écomposta  de  expressões. 
A  capacidade  de  combinar  estruturas  de  controle  com  outrasexpressões
permite  exprimir  muitos  padrões  comuns  de  forma  concisa.
 */

fun max(a: Int, b: Int): Int {
  return if(a > b) a else b
}

/*
Você  pode  simplificar  mais  ainda  a  função  anterior.  Como  seu  corpo
é constituído  de  uma  única  expressão,  podemos  usá-la  como  o  corpo
todo  dafunção, removendo as chaves e a instrução return
 */

fun max(a: Int, b: Int): Int = if(a > b) a else b

// Você pode simplificar mais ainda a função max e omitir o tipo de retorno

fun max(a: Int, b: Int) = if (a > b) a else b
```

## Basic Class

```java
// Classe Person em Java 

public class Person {
  private final String name;
  
  public Person(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
}
```

```kotlin
// Mesma class acima em Kotlin

data class Person(val name: String)
```

## Funções de nível superior

```kotlin
// 3.3 Declarando joinToString como uma função de nível superior

package strings

fun <T> joinToString(
  collection: Collection<T>,
  separator: String = ",",
  prefix: String = "",
  postfix: String = ""
) : String {
  val result = StringBuilder(prefix)
  for((index, element) in collection.withIndex()) {
    if (index > 0) result.append(separator)
    result.append(element)
  }
  result.append(postfix)
  return result.toString()
}
```
```kotlin
// Importando a funçao de nível superior

import strings.joinToString

val list = listOf(2, 4, 5)
joinToString(list, suffix = ";", prefix = "# ")
```

## Parâmetros default value

```kotlin
// 3.2 Declarando `joinToString()` com valores default para os parâmetros

fun <T> joinToString(
  collection: Collection<T>,
  separator: String = ",",
  prefix: String = "",
  postfix: String = ""
) : String {
  val result = StringBuilder(prefix)
  for((index, element) in collection.withIndex()) {
    if (index > 0) result.append(separator)
    result.append(element)
  }
  result.append(postfix)
  return result.toString()
}

/* Se  argumentos  nomeados  forem  usados,  você  poderá omitir alguns argumentos
do meio da lista e especificar somente aqueles queforem necessários, em qualquer
ordem desejada
 */

val list = listOf(2, 4, 5)
joinToString(list, suffix = ";", prefix = "# ")
```

## Funções de extensão e propriedades

```kotlin
// 3.3 Funções de extensão e propriedades

package strings

fun String.lastChar(): Char = this.get(this.length - 1)

// `String` é o tipo no qual a extensão é definida
// `this` é a instância desse tipo

>>> println("Kotlin".lastChar()) // n

// Podemos omitir o this e o retorno neste exemplo

fun String.lastChar() = get(length - 1)
```

```kotlin
// 3.1 Importações e funções de extensão

import strings.lastChar // 1 
import strings.* // 2 
import strings.lastChar as last // 3
val c = "Kotlin".lastChar()
```

```kotlin
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
```

```kotlin
/*
Vamos supor que queiramos obter uma função `join` que possa ser chamada somente
por string.
*/ 

fun Collection<String>.join(
  separator: String = ",",
  prefix: String = "",
  postfix: String = ""
) = joinToString(" ")
```

```kotlin
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
```

```kotlin
// 3.6 Sem sobrescritas para funções de extensões

fun View.showOff() = println("I`m a view!")
fun Button.showOff() = println("I`m a button!")

>>> val view: View = Button()
>>> view.showOff() // I`m a view!
```

```kotlin
// 3.7 Declarando uma propriedade de extensão

val String.lastChar: Char
  get() = get(length - 1)

>>> println("Kotlin".lastChar) // n
```

```kotlin
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
```

## Smart Cast
```kotlin
/*
Se você verificar a variávelpara saber se ela é de determinado tipo,
não será preciso fazer cast dela depois;você poderá usá-la como se tivesse o
tipo com o qual a verificação foi feita.
 */

if(e is Num) {
  val n = e as Num // cast redundante, não é necessário
  return n.value
}

/* 
O cast inteligente só funcionará se uma variável não puder ser alterada após
averificação com is. Quando usar um cast inteligente com uma propriedade deuma
classe, como nesse exemplo, a propriedade deve ser um val e não poderá terum método
`de acesso personalizado
*/
```

## Varargs

```kotlin
// 3.4.2 Varargs: funções que aceitam um número arbitrário de argumentos

/*
Quando chamamos uma funcão para criar umalista, podemos passar qualquer quantidade
de argumento a ela:
*/

val list = listOf(1, 2, 3, 4)

// Se obervamos como essa função está declarada, veremos o seguinte:

fun listOf<T>(vararg values: T): List<T> { ... }

// Exemplo

fun createList(vararg args: String): List<String> {
    return listOf(*args)
}

>>> val list = createList("Joao", "Maria")
>>> println(list) // [Joao, Maria]
```

## Enum

```kotlin
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
```

## When

```kotlin
// Usando when para escolher o valor correto do enum

fun getMnemonic(color: Color) = // u
  when(color) { // v
    Color.RED -> "Richard"
    Color.ORANGE -> "Of"
    Color.BLUE -> "Battle"
  }

// u Devolve diretamente uma expressão when
// v Devolve a string correspondente se a cor for igual ã constante do enum
```

```kotlin
// 2.13 Combinando opções em um ramo de when

fun getWarmth(color: Color) =
  when(color) {
    Color.RED, Color.ORANGE -> "warm"
    Color.GREEN -> "neutral"
    else -> throw Exception("Dirty color")
  }
```


```kotlin
// 2.3.4 Usando when sem argumentos

fun mixOptmized(c1: Color, c2: Color) = 
  when {
    (c1 == Color.RED && c2 == Color.YELLOW) -> Color.ORANGE
    else -> throw Exception("Dirty color")
  }
```

```kotlin
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
```

```kotlin
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
```

## For

```kotlin
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
```

```kotlin
// 2.23 Iterando por um intervalo com um passo

for(i in 100 downTo 1 step 2) {
  println(fizBuzz(i))
}
```

```kotlin
// 2.24 Iterando por um mapa

val binaryReps = HashMap<Char, String>()

for (letter in 'A'..'F') {
  binaryReps[letter] = Integer.toBinaryString(letter.toInt())
}

for((letter, binary) in binaryReps) {
  println("$letter = $binary")
}

/*
Podemos  usar  a  mesma  sintaxe  de  desempacotamento  para  iterar  por 
uma coleção, ao  mesmo  tempo  que  controlamos  o  índice  do  item  atual.
*/

val list = arrayListOf("10", "11", "1001")

for((index, element) in list.withIndex()) { // u
  println("$index:$element")
}

// u Itera por uma coleção usando índice.
```

## Try Catch

```kotlin
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
```

```kotlin
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
```

## In 

```kotlin
// 2.25 Verificando a pertinência a um intervalo usando in

fun isLetter(letter: Char) = letter in 'a'..'z' || letter in 'A'..'Z'
fun isNotDigit(digit: Char) = digit !in '0'..'9'

println(isLetter('A')) // true
println(isNotDigit('0')) // false
```

```kotlin
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
```

##  Métodos de acesso personalizados

```kotlin
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
```

## Expressões regulares e string com aspas triplas

```kotlin
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
```

```kotlin
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
```

```kotlin
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
```

## Infix

```kotlin
// 3.4.3 Trabalhando com pares: chamadas infixas

// Para criar mapas:
val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

/*
A palavra `to` é uma chamada de método do tipo especial infixa.
Chamadas infixas podem ser usadas com métodos usuais e funções de extensão que 
tenham um parâmetro obrigatório
 */ 

1.to("one") // u
1 to "one" // v

// u Chama a função `to` do modo usual
// v Chama a função `to` usanfo a notação infixa

// Eis uma versão simplifica de `to`

infix fun Any.to(other: Any) = Pair(this, other)
```

## DRY - Don`t repeat yourself

```kotlin
// 3.11 Uma função com código repetitivo

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
  if(user.name.isEmpty()) { // u
    throw IllegalArgumentException("Cant save user ${user.id}: empty Name")
  }
  if(user.addres.isEmpty()) { // u
    throw IllegalArgumentException("Cant save user ${user.id}: empty Address")
  }
  // Salva o usuário no banco
}

// u A validação está duplicada
```

```kotlin
// 3.12 - Extraindo uma função local para evitar repetição

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
  fun validate(user: User, value: String, fieldName: String) // u {
    if(value.isEmpty()) {
      throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
    }
  }
  validate(user, user.name, "Name") // v 
  validate(user, user.address, "Address") // v 
  // Salva o usuário no banco de dados
}

// u Declara uma função local para validar qualquer campo.
// v Chama a função local para validar campos
````

```kotlin
// 3.13 Acessando parâmetros da função externa em uma função local

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
  fun validate(value: String, fieldName: String) { // u
    if(value.isEmpty()) {
      throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName") // v
    }
  }
  validate(user, user.name, "Name")
  validate(user, user.address, "Address")
  // Salva o usuário no banco de dados
}

// u Agora não duplicamos o parâmetro user da função saveUser.
// v Podemos acessar parâmetros da função externa diretamente.
```

```kotlin
// 3.14 Extraindo a lógica para uma função de extensão

class User(val id: Int, val name: String, val address: String)

fun User.validadeBeforeSave() {
  fun validate(value: String, fieldName: String) {
    if(value.isEmpty()) {
      throw IllegalArgumentException("Can't save user $id: empty $fieldName") // u
    }
  }
  validate(name, "Name")
  validate(address, "Address")
}

fun saveUser(user: User) {
  user.validadeBeforeSave() // v
  // Salva o usuário no banco de dados
}

// u Podemos acessar as propriedades de User diretamente
// v Chama a função de extensão 
```