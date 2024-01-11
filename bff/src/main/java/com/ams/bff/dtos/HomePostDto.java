package com.ams.bff.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//This will list the posts to be displayed on the main page. Each post must include
//Author Name, Post Title, and limited content (first N characters), along with post's ID
//for navigation and user's ID to access the user's profile.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HomePostDto {
  private Long id;

  private String authorName;

  private String postTitle;

  private String limitedContent;

  private Long userId;
}
