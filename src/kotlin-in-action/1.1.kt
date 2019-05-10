data class Person(val name: String, val age: Int? = null)

val persons = listOf(Person("Alice"), Perosn("Bob", 20))
val oldest = persons.maxBy { it.age :? 0 }
