package com.ams.postservice.mapper;


import com.ams.postservice.dtos.PostDto;
import com.ams.postservice.entities.Post;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CommentMapper.class, PostLikeMapper.class, CommentLikeMapper.class})
public interface PostMapper {

  Post toEntity(PostDto postRequestDto);

  PostDto toDto(Post post);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Post partialUpdate(PostDto postDto, @MappingTarget Post post);
}
