package com.ams.postservice.controllers;

import com.ams.postservice.dtos.PostDto;
import com.ams.postservice.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  public final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @Operation(summary = "Get all posts")
  @ApiResponse(responseCode = "200", description = "Found the posts",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = PostDto.class)) })
  @GetMapping
  public ResponseEntity<List<PostDto>> getPostDtos(){
    return ResponseEntity.ok(postService.findAll());
  }

  @Operation(summary = "Create a new posts")
  @ApiResponse(responseCode = "200", description = "PostDto created successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = PostDto.class)) })
  @PostMapping
  public ResponseEntity<PostDto> createPostDto(@RequestBody PostDto postsDto){
    return ResponseEntity.ok(postService.save(postsDto));
  }

  @Operation(summary = "Get a posts by ID")
  @ApiResponse(responseCode = "200", description = "Found the posts",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = PostDto.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<PostDto> getPostDtoById(@Parameter(description = "ID of the posts to be obtained") Long id){
    return ResponseEntity.ok(postService.findById(id));
  }

  @Operation(summary = "Update a posts")
  @ApiResponse(responseCode = "200", description = "PostDto updated successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = PostDto.class)) })
  @PutMapping("/{id}")
  public ResponseEntity<PostDto> updatePostDto(@Parameter(description = "ID of the posts to be updated") @PathVariable Long id,
                                               @RequestBody PostDto postsDto){
    return ResponseEntity.ok(postService.update(id, postsDto));
  }

  @Operation(summary = "Delete a posts")
  @ApiResponse(responseCode = "204", description = "PostDto deleted successfully")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePostDto(@Parameter(description = "ID of the posts to be deleted") @PathVariable Long id){
    postService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
