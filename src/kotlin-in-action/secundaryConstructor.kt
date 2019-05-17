// 4.2.2 Construtores secundarários: inicializando a superclasse de modos diferentes

open class View {
  constructor(ctx: Context) { // u
    // algum código
  }
  constructor(ctx: Context, attr: AttributeSet) { // u 
    // algum código
  }
}

// u Construtores secundários

/* 
  Se quiser estender essa classe acima, você poderá declarar os mesmos construtores
*/

class MyButton : View {
  constructor(ctx: Context) : super(ctx) { // u
    // algum código
  }
  constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) { // u 
    // algum código
  }
}

// u Chama os construtores da superclasse

// 4.3 Usando construtores diferentes da sueprclasse

class MyButton : View {
  constructor(ctx) : this(ctx, MY_STYLE) { // u
    // algum código
  }
  constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {
    // algum código
  }
}

// u Delega para outro construtor da classe

