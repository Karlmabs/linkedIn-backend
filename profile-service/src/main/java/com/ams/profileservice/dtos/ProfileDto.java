package com.ams.profileservice.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

  private Long id;

  private Long userId;

  private String currentJobTitle;

  private String industry;

  private String summary;

  private String headline;

  private String website;

  private boolean isOpenForWork;

}
