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

// Importando a funçao de nível superior

import strings.joinToString

val list = listOf(2, 4, 5)
joinToString(list, suffix = ";", prefix = "# ")