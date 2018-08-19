package com.playwith.dropwizard;

import java.util.concurrent.atomic.AtomicLong;

import com.playwith.dropwizard.resource.MyAppResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyApplication extends Application<MyAppConfiguration> {
  public static void main(String[] args) throws Exception {
    new MyApplication().run(args);
    System.out.println("hey there");
  }

  @Override
  public void run(MyAppConfiguration configuration, Environment environment) throws Exception {
    final MyAppResource resource = new MyAppResource(configuration.getTemplate(), configuration.getDefaultName(), new AtomicLong());
    final TemplateHealthCheck healthCheck =
        new TemplateHealthCheck(configuration.getTemplate());
    environment.healthChecks().register("template", healthCheck);
    environment.jersey().register(resource);
  }

  @Override
  public void initialize(Bootstrap<MyAppConfiguration> bootstrap) {
    // nothing to do yet
  }
}
