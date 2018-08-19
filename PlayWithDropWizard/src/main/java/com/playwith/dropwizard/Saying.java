package com.playwith.dropwizard;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Saying {
  @JsonProperty
  private long id;

  @JsonProperty
  @Length(max = 3)
  private String content;
}
