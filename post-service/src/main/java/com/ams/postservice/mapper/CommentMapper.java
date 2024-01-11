package com.ams.postservice.mapper;


import com.ams.postservice.dtos.CommentDto;
import com.ams.postservice.entities.Comment;
import com.ams.postservice.entities.Post;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CommentLikeMapper.class})
public interface CommentMapper {

  Comment toEntity(CommentDto commentRequestDto);

  @Mapping(target = "parentCommentId", expression = "java(mapParentComment(comment.getParentComment()))")
  @Mapping(target = "repliesIds", expression = "java(mapReplies(comment.getReplies()))")
  @Mapping(target = "postId", expression = "java(mapPost(comment.getPost()))")
  CommentDto toDto(Comment comment);

  default Long mapParentComment(Comment comment) {
    if (comment == null) {
      return null;
    }
    return comment.getId();
  }

  default Set<Long> mapReplies(Set<Comment> replies) {
    if (replies == null) {
      return null;
    }
    return replies.stream().map(Comment::getId).collect(Collectors.toSet());
  }

  default Long mapPost(Post post) {
    if (post == null) {
      return null;
    }
    return post.getId();
  }

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Comment partialUpdate(CommentDto commentDto, @MappingTarget Comment comment);
}
