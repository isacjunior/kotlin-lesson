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
