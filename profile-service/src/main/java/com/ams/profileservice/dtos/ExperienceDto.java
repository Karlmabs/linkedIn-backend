package com.ams.profileservice.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDto {

  private Long id;

  private Long profileId;

  private String jobTitle;

  private String companyName;

  private String location;

  private Date startDate;

  private Date endDate;
}
