package com.ams.postservice.controllers;

import com.ams.postservice.dtos.CommentDto;
import com.ams.postservice.services.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
  public final CommentService commentService;

  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @Operation(summary = "Get all comments")
  @ApiResponse(responseCode = "200", description = "Found the comments",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = CommentDto.class)) })
  @GetMapping
  public ResponseEntity<List<CommentDto>> getCommentDtos(){
    return ResponseEntity.ok(commentService.findAll());
  }

  @Operation(summary = "Create a new comments")
  @ApiResponse(responseCode = "200", description = "CommentDto created successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = CommentDto.class)) })
  @PostMapping
  public ResponseEntity<CommentDto> createCommentDto(@RequestBody CommentDto commentsDto){
    return ResponseEntity.ok(commentService.save(commentsDto));
  }

  @Operation(summary = "Get a comments by ID")
  @ApiResponse(responseCode = "200", description = "Found the comments",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = CommentDto.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<CommentDto> getCommentDtoById(@Parameter(description = "ID of the comments to be obtained") @PathVariable Long id){
    return ResponseEntity.ok(commentService.findById(id));
  }

  @Operation(summary = "Update a comments")
  @ApiResponse(responseCode = "200", description = "CommentDto updated successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = CommentDto.class)) })
  @PutMapping("/{id}")
  public ResponseEntity<CommentDto> updateCommentDto(@Parameter(description = "ID of the comments to be updated") @PathVariable Long id,
                                                     @RequestBody CommentDto commentsDto){
    return ResponseEntity.ok(commentService.update(id, commentsDto));
  }

  @Operation(summary = "Delete a comments")
  @ApiResponse(responseCode = "204", description = "CommentDto deleted successfully")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCommentDto(@Parameter(description = "ID of the comments to be deleted") @PathVariable Long id){
    commentService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
