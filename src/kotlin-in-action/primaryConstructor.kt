// 4.2.1 Inicializando classes: construtor primário e blocls de inicialização

class User construtor(_nickName: String) { // u
  val nickName: String
  init { // v
    nickName = _nickName
  }
}

// u Construtor primário com parâmetro.
// v Bloco de inicialização.

class User(_nickName: String) { // u
  val nickName = _nickName // v
}

// u Construtor primário com um parâmetro
// v A propriedade é inicializada com o parâmetro

class User(val nickName: String) // um

// u val quer dizer que a propriedade correspondente é gerada para o parâmetro do construtor.

/*
Todas  as  declarações  da  classe User  são  equivalentes,
mas  a  última  utiliza  asintaxe mais concisa.
*/




