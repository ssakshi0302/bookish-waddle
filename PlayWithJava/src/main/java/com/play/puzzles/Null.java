package com.play.puzzles;

public class Null {
    public static String greet() {
        return "Hello world!";
    }

    public static void main(String[] args) {
        System.out.println(((Null) null).greet());
    }
}
