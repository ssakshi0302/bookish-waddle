package com.play.log;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/*
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.logging.log4j.ThreadContext;
*/

//@Slf4j
public class Child implements Runnable {

//  private Logger log = Logger.getLogger(ChildCopy.class);

  public void run() {
   /* System.out.println("dfdf" + System.getProperty("log4j2.isThreadContextMapInheritable"));
    final Hashtable<String, Object> context = MDC.getContext();
    final Map<String, String> threadContext1 = ThreadContext.getContext();
    threadContext1.put("UDss", "ssstest");*/
    // MDC.setContextMap(copyOfContextMap);  // set contextMap when thread start

    final ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.submit(new ChildCopy());

    //   MDC.setContextMap(contextMap);  // set contextMap when thread start
  //  log.info("Running in the child thread");
  }
}