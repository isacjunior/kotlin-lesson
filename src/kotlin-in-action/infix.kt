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
