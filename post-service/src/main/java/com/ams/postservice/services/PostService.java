package com.ams.postservice.services;

import com.ams.postservice.dtos.PostDto;
import com.ams.postservice.entities.Post;
import com.ams.postservice.exceptions.ResourceNotFoundException;
import com.ams.postservice.mapper.PostMapper;
import com.ams.postservice.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
  private final PostRepository postRepository;
  private final PostMapper postMapper;

  public PostService(PostRepository postRepository, PostMapper postMapper) {
    this.postRepository = postRepository;
    this.postMapper = postMapper;
  }

  public List<PostDto> findAll(){
    return postRepository.findAll().stream().map(postMapper::toDto).collect(Collectors.toList());
  }

  public PostDto findById(Long id) {
    return postMapper.toDto(postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id)));
  }

  public PostDto save(PostDto postDto) {
    Post post = postMapper.toEntity(postDto);
    return postMapper.toDto(postRepository.save(post));
  }

  public PostDto update(long id, PostDto postDto) {
    Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
    post = postMapper.partialUpdate(postDto, post);
    return postMapper.toDto(postRepository.save(post));
  }

  public void delete(Long id) {
    postRepository.deleteById(id);
  }
}
