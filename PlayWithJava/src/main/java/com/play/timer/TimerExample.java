package com.play.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
  public static void main(String[] args) {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {

      }
    },60*60);

  }
}
