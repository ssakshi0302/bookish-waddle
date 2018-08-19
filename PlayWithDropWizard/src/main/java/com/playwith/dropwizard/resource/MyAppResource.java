package com.playwith.dropwizard.resource;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import com.codahale.metrics.annotation.Timed;
import com.playwith.dropwizard.Saying;

import lombok.AllArgsConstructor;

//@Singleton
@AllArgsConstructor
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class MyAppResource {
  private final String template;
  private final String defaultName;
  private final AtomicLong counter;

  @GET
  @Timed
  @Path("/name")
  // public Saying sayHello(@QueryParam("name") Optional<String> name) {
  public Saying sayHello(@QueryParam("name") String name) {
    final String value = String.format(template, StringUtils.defaultString(name, defaultName));
    //  final String value = String.format(template, name.orElse(defaultName));
    return new Saying(counter.incrementAndGet(), value);
  }
}