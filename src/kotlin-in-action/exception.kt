// 2.5 Exceções em Kotlin

if(percentage !in 0..100) {
  throw IllegalArgumentException("A parcentage value must be between 0 and 100")
}

/*
Diferentemente de Java, em Kotlin, a construção throw é uma expressão e podeser
usada como parte de outras expressões:
 */

val percentage = 
  if(number in 0..100)
    number
  else
    throw IllegalArgumentException("A parcentage value must be between 0 and 100")

