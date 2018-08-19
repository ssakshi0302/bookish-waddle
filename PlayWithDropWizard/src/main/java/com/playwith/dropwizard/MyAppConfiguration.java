package com.playwith.dropwizard;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyAppConfiguration extends Configuration {
  @JsonProperty
  @NotEmpty
  private String template;

  @JsonProperty
  @NotEmpty
  private String defaultName = "Stranger";
}
