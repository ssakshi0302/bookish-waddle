package com.play.puzzles;

public class Lazy {
    private static boolean initialized = false;

    static {
        Thread thread = new Thread(() -> {
            System.out.println("in static thread 11");
            //System.out.println(initialized);
            initialized=true;
            System.out.println(initialized);
            System.out.println("in static thread 12");
        });
        thread.start();
        try {
            System.out.println("before join");
            Thread.sleep(700);
            System.out.println("after sleep");
            //thread.join();
            System.out.println("hihi");
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

  /*  static {
        System.out.println("static    " +  initialized);
    }*/

    public static void main(String[] args) {
        System.out.println(initialized);
        /*try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */System.out.println(initialized);
    }
}