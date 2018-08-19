package com.play.puzzles;

public class ShadesOfGray {
    public static void main(String[] args) {
        System.out.println(X.Y.Z);
    }
}

class X {
    static class Y {
        static String Z = "Black";
    }

    static C Y = new C(); //variable takes preference over type
}

class C {
    static String Z = "White";
}