package com.ams.postservice.services;

import com.ams.postservice.dtos.CommentLikeDto;
import com.ams.postservice.entities.CommentLike;
import com.ams.postservice.exceptions.ResourceNotFoundException;
import com.ams.postservice.mapper.CommentLikeMapper;
import com.ams.postservice.repositories.CommentLikeRepository;
import com.ams.postservice.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentLikeService {
  private final CommentLikeRepository commentLikeRepository;
  private final CommentLikeMapper commentLikeMapper;

  private final CommentRepository commentRepository;

  public CommentLikeService(CommentLikeRepository commentLikeRepository, CommentLikeMapper commentLikeMapper, CommentRepository commentRepository) {
    this.commentLikeRepository = commentLikeRepository;
    this.commentLikeMapper = commentLikeMapper;
    this.commentRepository = commentRepository;
  }

  public List<CommentLikeDto> findAll(){
    return commentLikeRepository.findAll().stream().map(commentLikeMapper::toDto).collect(Collectors.toList());
  }

  public CommentLikeDto findById(Long id) {
    return commentLikeMapper.toDto(commentLikeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CommentLike", "id", id)));
  }

  public CommentLikeDto save(CommentLikeDto commentLikeDto) {
    CommentLike commentLike = commentLikeMapper.toEntity(commentLikeDto);
    commentLike.setComment(commentRepository.findById(commentLikeDto.getCommentId()).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentLikeDto.getCommentId())));
    return commentLikeMapper.toDto(commentLikeRepository.save(commentLike));
  }

  public CommentLikeDto update(long id, CommentLikeDto commentLikeDto) {
    CommentLike commentLike = commentLikeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CommentLike", "id", id));
    commentLike = commentLikeMapper.partialUpdate(commentLikeDto, commentLike);
    commentLike.setComment(commentRepository.findById(commentLikeDto.getCommentId()).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentLikeDto.getCommentId())));
    return commentLikeMapper.toDto(commentLikeRepository.save(commentLike));
  }

  public void delete(Long id) {
    commentLikeRepository.deleteById(id);
  }
}
