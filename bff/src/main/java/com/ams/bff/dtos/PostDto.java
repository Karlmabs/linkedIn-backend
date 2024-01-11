package com.ams.bff.dtos;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
  private Long id;

  private Long profileId; // Reference to the Profile entity in the Profile Microservice

  private String title;

  private String content;

  private Date creationDate;

  private Set<CommentDto> comments;

  private Set<PostLikeDto> likes;
}
