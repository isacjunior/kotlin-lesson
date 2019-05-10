// Classe Person em Java 

public class Person {
  private final String name;
  
  public Person(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
}

// Classe Person em Kotlin

data class Person(val name: String)