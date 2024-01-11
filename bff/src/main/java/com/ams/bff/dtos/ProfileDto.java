package com.ams.bff.dtos;

import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

  private Long id;

  private Long userId; // Reference to User entity in User Microservice

  private String currentJobTitle;

  private String industry;

  private String summary;

  private String headline;

  private String website;

  private Boolean openForWork;

  private List<EducationDto> education;

  private List<ExperienceDto> experiences;

  private List<ProfileSkillDto> skills;

  private Set<Long> connections;

}
