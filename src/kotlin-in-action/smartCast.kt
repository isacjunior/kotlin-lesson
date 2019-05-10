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