package com.ams.postservice.mapper;


import com.ams.postservice.dtos.PostDto;
import com.ams.postservice.entities.Post;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {

  Post toEntity(PostDto postRequestDto);

  PostDto toDto(Post post);

//  List<PostDto> toDtoList(List<Post> posts);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Post partialUpdate(PostDto postDto, @MappingTarget Post post);
}
