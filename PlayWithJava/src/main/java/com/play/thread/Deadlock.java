package com.play.thread;

public class Deadlock {

  public static void main(String[] args) {
    final Friend alphonse =
        new Friend("Alphonse");
    final Friend gaston =
        new Friend("Gaston");
    new Thread(new Runnable() {
      public void run() { alphonse.bow(gaston); }
    }).start();
    new Thread(new Runnable() {
      public void run() { gaston.bow(alphonse); }
    }).start();
  }

  static class Friend {
    private final String name;

    public Friend(String name) {
      this.name = name;
    }

    public String getName() {
      return this.name;
    }

    public void bow(Friend bower) {
      System.out.println(Thread.currentThread().getName() + this);
      synchronized (this) {
        System.out.format("%s: %s"
                + "  has bowed to me!%n",
            this.name, bower.getName());
        bower.bowBack(this);
      }
    }

    public void bowBack(Friend bower) {
      System.out.println("in bowback " + Thread.currentThread().getName() + this);
      synchronized (this) {
        System.out.format("%s: %s"
                + " has bowed back to me!%n",
            this.name, bower.getName());
      }
    }
  }
}
