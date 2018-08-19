package com.play.inherit;

public class Animal {

  static void aghd() {
    System.out.println("euuuuuuuuuuu");
  }

  public void method() {
    System.out.println("Animal");
  }
}

class Horse extends Animal {
  public static void main(String[] args) throws Exception {
    Animal b = new Horse();
    b.method();
    Animal a = new Animal();
    a.method();
    Horse horse = new Horse();
    ((Animal) horse).aghd();
    Animal.aghd();
    horse.aghd();

  }

  static void aghd() {
    System.out.println("dujckck");
  }

  public void method() {
    System.out.println("Horse");
  }

  public void test() {}
}
