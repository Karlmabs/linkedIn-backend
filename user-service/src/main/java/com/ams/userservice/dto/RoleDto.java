package com.ams.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

//@Value
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleDto implements Serializable {

  private Long id;
  private String name;
  private String code;
  private String description;

}
