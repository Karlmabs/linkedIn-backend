package com.ams.profileservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDto implements Serializable {

  private Long id;

  private Long profileId;

  private String jobTitle;

  private String companyName;

  private String location;

  private Date startDate;

  private Date endDate;
}
