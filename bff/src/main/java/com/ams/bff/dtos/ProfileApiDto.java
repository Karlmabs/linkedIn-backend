package com.ams.bff.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileApiDto {

  private Long id;

  private String username;

  private String email;

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
