package com.play.puzzles;

public class SelfInterruption {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        if (Thread.currentThread().isInterrupted()) {
            System.out.println("Interrupted: " +
                    Thread.currentThread().isInterrupted());
        } else {
            System.out.println("Not interrupted: " +
                    Thread.currentThread().isInterrupted());
        }
    }
}
