package com.ams.bff.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto implements Serializable {

  private Long id;

  private Long profileId;

  private String school;

  private String degree;

  private String fieldOfStudy;

  private Date startDate;

  private Date endDate;

}
