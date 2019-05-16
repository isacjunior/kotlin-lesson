// 4.11 Classe aninhada

class Button : View {
  override fun getCurrentState(): State = ButtonState()
  override fun restoreState(state: State) { /* ... */ }
  class ButtonState : State { /* ... */ } // u
}

// u Essa classe é semehante a uma classe estática aninhada em Java.

