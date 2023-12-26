package com.ams.postservice.mapper;


import com.ams.postservice.dtos.CommentDto;
import com.ams.postservice.entities.Comment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {

  Comment toEntity(CommentDto commentRequestDto);

  CommentDto toDto(Comment comment);

//  List<CommentDto> toDtoList(List<Comment> comments);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Comment partialUpdate(CommentDto commentDto, @MappingTarget Comment comment);
}
