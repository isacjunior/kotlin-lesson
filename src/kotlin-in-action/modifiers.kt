// 4.1 O significado dos modificadores de acesso em uma classe

/*
| Modificador  | Membro correspondente | Comentários  | 
| ------------- | ------------- | ------------- |
| final  | Não pode ser sobrescrito  | Usado por padrão para membros da classe  |
| open  | Pode ser sobrescrito  | Deve ser especificado explicitamente  |
| abstract  | Deve ser sobrescrito  | Pode ser usado somente em classes abstratas; membros abstratos não podem ter uma implementação  |
| override  | Sobrescreve um membro de uma superclasse ou de uma interface  | O membro sobrescrito é aberto por padrão caso não seja marcado com final  |
*/

// 4.2 Modificadores de visibilidade em Kotlin

/*
| Modificador  | Membro da classe | Declaração de nível superior |
| ------------- | ------------- | ------------- |
| public(default)  | Visível em todos os lugares  | Visível em todos os lugares  |
| internal  | Vísivel em um módulo  | Vísivel em um módulo  |
| protected  | Vísivel em subclasses  | --  |
| private  | Vísivel em uma classe  | Vísivel em um arquivo  |
 */

internal open class TalkativeButton {
  private fun yell() = println("Hey!")
  protected fun whisper() =  println("Let's talk!")
}

fun TalkativeButton.giveSpeech() { // u
  yell() // v
  whisper() // w
}

// u Erro: membro `public` expõe seu tipo receptor TalkativeButton `internal`
// v Erro: não é possível acessar `yell` - é `private` em `TalkativeButton`.
// w Erro: não é possível acessar `whisper` - é `protected` em `TalkativeButton`.

