package com.ams.postservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Serializable {
  private Long id;

  private Long profileId; // Reference to the Profile entity in the Profile Microservice

  private String content;

  private Date creationDate;

  private Long parentCommentId;

  private Set<Long> repliesIds;

  private Set<CommentLikeDto> likes;

  private Long postId;
}
