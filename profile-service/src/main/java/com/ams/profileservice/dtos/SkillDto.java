package com.ams.profileservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillDto implements Serializable {
  private Long id;

  private String name;

  private List<Long> profileSkills;
}
