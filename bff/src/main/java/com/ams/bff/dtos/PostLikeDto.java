package com.ams.bff.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostLikeDto implements Serializable {
  private Long id;

  private Long postId;

  private Long profileId; // Reference to the Profile entity in the Profile Microservice
}
