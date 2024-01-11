package com.ams.postservice.controllers;

import com.ams.postservice.dtos.PostLikeDto;
import com.ams.postservice.services.PostLikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postLikes")
public class PostLikeController {
  public final PostLikeService postLikeService;

  public PostLikeController(PostLikeService postLikeService) {
    this.postLikeService = postLikeService;
  }

  @Operation(summary = "Get all postLikes")
  @ApiResponse(responseCode = "200", description = "Found the postLikes",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = PostLikeDto.class)) })
  @GetMapping
  public ResponseEntity<List<PostLikeDto>> getPostLikeDtos(){
    return ResponseEntity.ok(postLikeService.findAll());
  }

  @Operation(summary = "Create a new postLikes")
  @ApiResponse(responseCode = "200", description = "PostLikeDto created successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = PostLikeDto.class)) })
  @PostMapping
  public ResponseEntity<PostLikeDto> createPostLikeDto(@RequestBody PostLikeDto postLikesDto){
    return ResponseEntity.ok(postLikeService.save(postLikesDto));
  }

  @Operation(summary = "Get a postLikes by ID")
  @ApiResponse(responseCode = "200", description = "Found the postLikes",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = PostLikeDto.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<PostLikeDto> getPostLikeDtoById(@Parameter(description = "ID of the postLikes to be obtained") @PathVariable Long id){
    return ResponseEntity.ok(postLikeService.findById(id));
  }

  @Operation(summary = "Update a postLikes")
  @ApiResponse(responseCode = "200", description = "PostLikeDto updated successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = PostLikeDto.class)) })
  @PutMapping("/{id}")
  public ResponseEntity<PostLikeDto> updatePostLikeDto(@Parameter(description = "ID of the postLikes to be updated") @PathVariable Long id,
                                                     @RequestBody PostLikeDto postLikesDto){
    return ResponseEntity.ok(postLikeService.update(id, postLikesDto));
  }

  @Operation(summary = "Delete a postLikes")
  @ApiResponse(responseCode = "204", description = "PostLikeDto deleted successfully")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePostLikeDto(@Parameter(description = "ID of the postLikes to be deleted") @PathVariable Long id){
    postLikeService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
