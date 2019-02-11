package com.play;

public class AbstractTest extends Example implements Test{

  @Override
  public void hello(final String s) {

  }
}

abstract class Example implements Test {
  public abstract void hello(String s);
  void check(){}
}
abstract interface  Test{
  void hello(String s);
}