package com.ams.postservice.services;

import com.ams.postservice.dtos.CommentDto;
import com.ams.postservice.entities.Comment;
import com.ams.postservice.exceptions.ResourceNotFoundException;
import com.ams.postservice.mapper.CommentMapper;
import com.ams.postservice.repositories.CommentRepository;
import com.ams.postservice.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService {
  private final CommentRepository commentRepository;
  private final CommentMapper commentMapper;
  private final PostRepository postRepository;
  private final ProfileService profileService;

  public CommentService(CommentRepository commentRepository, CommentMapper commentMapper, PostRepository postRepository, ProfileService profileService) {
    this.commentRepository = commentRepository;
    this.commentMapper = commentMapper;
    this.postRepository = postRepository;
    this.profileService = profileService;
  }

  public List<CommentDto> findAll(){
    return commentRepository.findAll().stream().map(commentMapper::toDto).collect(Collectors.toList());
  }

  public CommentDto findById(Long id) {
    return commentMapper.toDto(commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id)));
  }

  public CommentDto save(CommentDto commentDto) {
    Comment comment = commentMapper.toEntity(commentDto);
    comment.setPost(postRepository.findById(commentDto.getPostId()).orElseThrow(() -> new ResourceNotFoundException("Post", "id", commentDto.getPostId())));
    profileService.getProfile(commentDto.getProfileId());
    if(commentDto.getParentCommentId() != null) {
      Comment comment1 = commentRepository.findById(commentDto.getParentCommentId()).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentDto.getParentCommentId()));
      comment.setParentComment(comment1);
      Comment save = commentRepository.save(comment);

      Set<Comment> replies = new HashSet<>();
      replies.add(save);
      comment1.setReplies(replies);
      commentRepository.save(comment1);

      return commentMapper.toDto(save);
    } else{
      return commentMapper.toDto(commentRepository.save(comment));
    }

  }

  public CommentDto update(long id, CommentDto commentDto) {
    Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
    comment = commentMapper.partialUpdate(commentDto, comment);
    comment.setPost(postRepository.findById(commentDto.getPostId()).orElseThrow(() -> new ResourceNotFoundException("Post", "id", commentDto.getPostId())));
    profileService.getProfile(commentDto.getProfileId());
    if(commentDto.getParentCommentId() != null) {
      Comment comment1 = commentRepository.findById(commentDto.getParentCommentId()).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentDto.getParentCommentId()));
      comment.setParentComment(comment1);
      Comment save = commentRepository.save(comment);

      Set<Comment> replies = new HashSet<>();
      replies.add(save);
      comment1.setReplies(replies);
      commentRepository.save(comment1);

      return commentMapper.toDto(save);
    } else{
      return commentMapper.toDto(commentRepository.save(comment));
    }
  }

  public void delete(Long id) {
    commentRepository.deleteById(id);
  }
}
