package com.ams.profileservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileSkillDto implements Serializable {
  private Long id;

  private Long profileId;

  private Long skillId;
}
