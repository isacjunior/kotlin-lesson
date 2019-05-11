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