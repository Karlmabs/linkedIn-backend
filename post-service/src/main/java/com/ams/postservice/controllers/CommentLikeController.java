package com.ams.postservice.controllers;

import com.ams.postservice.dtos.CommentLikeDto;
import com.ams.postservice.services.CommentLikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentLikes")
public class CommentLikeController {
  public final CommentLikeService commentLikeService;

  public CommentLikeController(CommentLikeService commentLikeService) {
    this.commentLikeService = commentLikeService;
  }

  @Operation(summary = "Get all commentLikes")
  @ApiResponse(responseCode = "200", description = "Found the commentLikes",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = CommentLikeDto.class)) })
  @GetMapping
  public ResponseEntity<List<CommentLikeDto>> getCommentLikeDtos(){
    return ResponseEntity.ok(commentLikeService.findAll());
  }

  @Operation(summary = "Create a new commentLikes")
  @ApiResponse(responseCode = "200", description = "CommentLikeDto created successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = CommentLikeDto.class)) })
  @PostMapping
  public ResponseEntity<CommentLikeDto> createCommentLikeDto(@RequestBody CommentLikeDto commentLikesDto){
    return ResponseEntity.ok(commentLikeService.save(commentLikesDto));
  }

  @Operation(summary = "Get a commentLikes by ID")
  @ApiResponse(responseCode = "200", description = "Found the commentLikes",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = CommentLikeDto.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<CommentLikeDto> getCommentLikeDtoById(@Parameter(description = "ID of the commentLikes to be obtained") @PathVariable Long id){
    return ResponseEntity.ok(commentLikeService.findById(id));
  }

  @Operation(summary = "Update a commentLikes")
  @ApiResponse(responseCode = "200", description = "CommentLikeDto updated successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = CommentLikeDto.class)) })
  @PutMapping("/{id}")
  public ResponseEntity<CommentLikeDto> updateCommentLikeDto(@Parameter(description = "ID of the commentLikes to be updated") @PathVariable Long id,
                                                     @RequestBody CommentLikeDto commentLikesDto){
    return ResponseEntity.ok(commentLikeService.update(id, commentLikesDto));
  }

  @Operation(summary = "Delete a commentLikes")
  @ApiResponse(responseCode = "204", description = "CommentLikeDto deleted successfully")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCommentLikeDto(@Parameter(description = "ID of the commentLikes to be deleted") @PathVariable Long id){
    commentLikeService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
