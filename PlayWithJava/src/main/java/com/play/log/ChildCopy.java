package com.play.log;

/*
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.logging.log4j.ThreadContext;
*/
//@Slf4j
public class ChildCopy implements Runnable {

//  private Logger log = Logger.getLogger(ChildCopy.class);
  // contextMap is set when new Child() is called
  //private Map<String, String> contextMap = MDC.getCopyOfContextMap();

  public void run() {
// MDC.getCopyOfContextMap();
    //log.info(MDC.get("IP"));
    /*final Hashtable<String, Object> context = MDC.getContext();
    ThreadContext.getContext();*/

    //  log.info("Running in the child copy thread");
  }
}