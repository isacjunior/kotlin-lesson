// 4.3.2 Data classes

data class Client(val name: String, val postalCode: Int)

/* Now you have a class that overrides all the standard Java methods 
  equals(): Para comparação de instâncias.
  hashCode(): Para usar como chaves em containers baseados em hashes, como HashMap.
  toString(): Para gerar a representação de strings que mostrem todos os campos na ordem da declaração.
*/

// Método copy()

class Client(val name: String, val postalCode: Int) {
  fun copy(name: String = this.name, postalCode: Int = this.postalCode) = Client(name, postalCode)
}

val bob = Client("Bob", 973293)
println(bob.copy(postalCode = 123)) // Client(name=Bob, postalCode=123)

