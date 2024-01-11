package com.ams.bff.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

//This API will provide full details of a single post, including Author name, Post title, as
//well as entire content. It should contain the IDs required to navigate to author's
//profile as well.
//The API should also fetch and display the comments on the post, featuring comment
//content and author name for each comment as well as the date. Only one level of
//comments should be returned, which means not including replies to these
//comments.

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostPageDto {

  private Long id;

  private Long profileId; // Reference to the Profile entity in the Profile Microservice

  private String postTitle;

  private String authorName;

  private String content;

  private Date creationDate;

  private Set<CommentPageDto> comments;

}
