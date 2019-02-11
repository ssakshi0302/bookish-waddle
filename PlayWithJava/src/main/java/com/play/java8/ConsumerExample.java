package com.play.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class ConsumerExample {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("one", "two", "three", "four");
//    Consumer<String> c1 = s -> System.out.println(s);
    Consumer<String> c1 = System.out::println;
    List<String> result = new ArrayList<>();
    //Consumer<String> c2 = s -> result.add(s);
    Consumer<String> c2 = result::add;
    list.forEach(c1.andThen(c2));
    result.forEach(c1);
    c2.accept(result.get(0));
   }
}
