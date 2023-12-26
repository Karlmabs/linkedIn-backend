package com.ams.postservice.controllers;

import com.ams.postservice.dtos.CommentDto;
import com.ams.postservice.services.CommentService;
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

  @GetMapping
  public ResponseEntity<List<CommentDto>> getComments(){
    return ResponseEntity.ok(commentService.findAll());
  }

  @PostMapping
  public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto){
    return ResponseEntity.ok(commentService.save(commentDto));
  }

  @GetMapping("/{id}")
  public ResponseEntity<CommentDto> getCommentById(Long id){
    return ResponseEntity.ok(commentService.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<CommentDto> updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto){
    return ResponseEntity.ok(commentService.update(id, commentDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteComment(@PathVariable Long id){
    commentService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
