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