package com.play.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

//import org.slf4j.MDC;

/*
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.logging.log4j.ThreadContext;
*/

//@Slf4j
public class Parent {
  static {
    System.setProperty("log4j2.isThreadContextMapInheritable", "true");
  }

  // private Logger log = Logger.getLogger(Parent.class);
  private ExecutorService executorService = Executors.newFixedThreadPool(5);

  public Parent() {
    // Mimic Web app, save common info in MDC

  }

  public static void main(String[] args) throws InterruptedException {
    Parent parent = new Parent();
    // MDC.put("IP", UUID.randomUUID().toString());
    //ThreadContext.put("fbd", "fjff");
    //final Map<String, String> context = ThreadContext.getContext();
    parent.runMultiThreadByExecutor();  //MDC OK

  }

  public void runMultiThreadByExecutor() throws InterruptedException {
    //  log.info("Before start child thread");

    executorService.submit(new Child());
    executorService.submit(new ChildCopy());
    //   log.info("After start child thread");

    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.SECONDS);
    //   log.info("ExecutorService is over");
  }
}