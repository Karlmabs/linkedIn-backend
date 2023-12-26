package com.ams.profileservice.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

  private Long id;

  private Long profileId;

  private String school;

  private String degree;

  private String fieldOfStudy;

  private Date startDate;

  private Date endDate;

}
