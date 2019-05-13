// 3.6 Deixando seu código organizado: funções locais e extensões - DRY - Don`t repeat yourself

// 3.11 Uma função com código repetitivo

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
  if(user.name.isEmpty()) { // u
    throw IllegalArgumentException("Cant save user ${user.id}: empty Name")
  }
  if(user.addres.isEmpty()) { // u
    throw IllegalArgumentException("Cant save user ${user.id}: empty Address")
  }
  // Salva o usuário no banco
}

// u A validação está duplicada

// 3.12 - Extraindo uma função local para evitar repetição

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
  fun validate(user: User, value: String, fieldName: String) // u {
    if(value.isEmpty()) {
      throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
    }
  }
  validate(user, user.name, "Name") // v 
  validate(user, user.address, "Address") // v 
  // Salva o usuário no banco de dados
}

// u Declara uma função local para validar qualquer campo.
// v Chama a função local para validar campos

// 3.13 Acessando parâmetros da função externa em uma função local

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
  fun validate(value: String, fieldName: String) { // u
    if(value.isEmpty()) {
      throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName") // v
    }
  }
  validate(user, user.name, "Name")
  validate(user, user.address, "Address")
  // Salva o usuário no banco de dados
}

// u Agora não duplicamos o parâmetro user da função saveUser.
// v Podemos acessar parâmetros da função externa diretamente.

// 3.14 Extraindo a lógica para uma função de extensão

class User(val id: Int, val name: String, val address: String)

fun User.validadeBeforeSave() {
  fun validate(value: String, fieldName: String) {
    if(value.isEmpty()) {
      throw IllegalArgumentException("Can't save user $id: empty $fieldName") // u
    }
  }
  validate(name, "Name")
  validate(address, "Address")
}

fun saveUser(user: User) {
  user.validadeBeforeSave() // v
  // Salva o usuário no banco de dados
}

// u Podemos acessar as propriedades de User diretamente
// v Chama a função de extensão 
