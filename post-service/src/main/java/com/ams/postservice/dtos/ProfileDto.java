package com.ams.postservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto implements Serializable {
  private Long id;

  private Long userId; // Reference to User entity in User Microservice

  private String currentJobTitle;

  private String industry;

  private String summary;

  private String headline;

  private String website;

  private Boolean openForWork;

  private Set<Long> connections;

}
