package com.ams.postservice.controllers;

import com.ams.postservice.dtos.PostDto;
import com.ams.postservice.services.PostService;
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

  @GetMapping
  public ResponseEntity<List<PostDto>> getPosts(){
    return ResponseEntity.ok(postService.findAll());
  }

  @PostMapping
  public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
    return ResponseEntity.ok(postService.save(postDto));
  }

  @GetMapping("/{id}")
  public ResponseEntity<PostDto> getPostById(Long id){
    return ResponseEntity.ok(postService.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody PostDto postDto){
    return ResponseEntity.ok(postService.update(id, postDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePost(@PathVariable Long id){
    postService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
