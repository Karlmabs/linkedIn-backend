package com.ams.postservice.dtos;

import com.ams.postservice.entities.Comment;
import com.ams.postservice.entities.PostLike;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto implements Serializable {
  private Long id;

  private Long profileId; // Reference to the Profile entity in the Profile Microservice

  private String title;

  private String content;

  private Date creationDate;

  private Set<CommentDto> comments;

  private Set<PostLikeDto> likes;
}
