package com.ams.postservice.services;

import com.ams.postservice.dtos.CommentDto;
import com.ams.postservice.entities.Comment;
import com.ams.postservice.exceptions.ResourceNotFoundException;
import com.ams.postservice.mapper.CommentMapper;
import com.ams.postservice.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
  private final CommentRepository commentRepository;
  private final CommentMapper commentMapper;

  public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
    this.commentRepository = commentRepository;
    this.commentMapper = commentMapper;
  }

  public List<CommentDto> findAll(){
    return commentRepository.findAll().stream().map(commentMapper::toDto).collect(Collectors.toList());
  }

  public CommentDto findById(Long id) {
    return commentMapper.toDto(commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id)));
  }

  public CommentDto save(CommentDto commentDto) {
    Comment comment = commentMapper.toEntity(commentDto);
    return commentMapper.toDto(commentRepository.save(comment));
  }

  public CommentDto update(long id, CommentDto commentDto) {
    Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
    comment = commentMapper.partialUpdate(commentDto, comment);
    return commentMapper.toDto(commentRepository.save(comment));
  }

  public void delete(Long id) {
    commentRepository.deleteById(id);
  }
}
