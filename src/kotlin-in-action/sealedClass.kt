// 4.13 Expressões como classes seladas

/* Quando avaliamos uma expressão usando a construção when, o compilador deKotlin  nos  força
a  verificar  a  opção  default.  Nesse  exemplo,  não  podemosdevolver algo significativo,
portanto, lançamos uma exceção.Ter que adicionar sempre um ramo default não é conveniente.
Além do mais, seacrescentarmos  uma  nova  subclasse,  o  compilador  não  detectará  que  algomudou.
Se  esquecermos  de  adicionar  um  novo  ramo,  o  ramo  default  seráescolhido, o que poderá resultar
em bugs sutis.Kotlin  oferece  uma  solução  para  esse  problema:  classes sealed.  Marque  umasuperclasse
com o modificador sealed, e isso restringirá a possibilidade de criarsubclasses.
Todas as subclasses diretas devem estar aninhadas na superclasse: */

sealed class Expr { // u
  class Num(val value: Int): Expr()
  class Sum(val left: Expr, val right: Expr) : Expr() // v
}

fun eval(e: Expr): Int =
  when(e) { // w
    is Expr.Num -> e.value
    is Expr.Sum -> eval(e.right) + eval(e.left)
  }

// u Marca uma classe-base como sealed
// v Lista
