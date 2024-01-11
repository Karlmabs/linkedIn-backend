package com.ams.postservice.mapper;

import com.ams.postservice.dtos.CommentLikeDto;
import com.ams.postservice.entities.Comment;
import com.ams.postservice.entities.CommentLike;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentLikeMapper {
  CommentLike toEntity(CommentLikeDto commentLikeRequestDto);

  @Mapping(target = "commentId", expression = "java(mapComment(commentLike.getComment()))")
  CommentLikeDto toDto(CommentLike commentLike);

  default Long mapComment(Comment comment) {
    if (comment == null) {
      return null;
    }
    return comment.getId();
  }

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  CommentLike partialUpdate(CommentLikeDto commentLikeDto, @MappingTarget CommentLike commentLike);
}
