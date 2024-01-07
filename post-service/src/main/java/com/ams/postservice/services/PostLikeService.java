package com.ams.postservice.services;

import com.ams.postservice.dtos.PostLikeDto;
import com.ams.postservice.entities.PostLike;
import com.ams.postservice.exceptions.ResourceNotFoundException;
import com.ams.postservice.mapper.PostLikeMapper;
import com.ams.postservice.repositories.PostLikeRepository;
import com.ams.postservice.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostLikeService {
  private final PostLikeRepository postLikeRepository;
  private final PostLikeMapper postLikeMapper;

  private final PostRepository postRepository;

  public PostLikeService(PostLikeRepository postLikeRepository, PostLikeMapper postLikeMapper, PostRepository postRepository) {
    this.postLikeRepository = postLikeRepository;
    this.postLikeMapper = postLikeMapper;
    this.postRepository = postRepository;
  }

  public List<PostLikeDto> findAll(){
    return postLikeRepository.findAll().stream().map(postLikeMapper::toDto).collect(Collectors.toList());
  }

  public PostLikeDto findById(Long id) {
    return postLikeMapper.toDto(postLikeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PostLike", "id", id)));
  }

  public PostLikeDto save(PostLikeDto postLikeDto) {
    PostLike postLike = postLikeMapper.toEntity(postLikeDto);
    postLike.setPost(postRepository.findById(postLikeDto.getPostId()).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postLikeDto.getPostId())));
    return postLikeMapper.toDto(postLikeRepository.save(postLike));
  }

  public PostLikeDto update(long id, PostLikeDto postLikeDto) {
    PostLike postLike = postLikeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PostLike", "id", id));
    postLike = postLikeMapper.partialUpdate(postLikeDto, postLike);
    postLike.setPost(postRepository.findById(postLikeDto.getPostId()).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postLikeDto.getPostId())));
    return postLikeMapper.toDto(postLikeRepository.save(postLike));
  }

  public void delete(Long id) {
    postLikeRepository.deleteById(id);
  }
}
