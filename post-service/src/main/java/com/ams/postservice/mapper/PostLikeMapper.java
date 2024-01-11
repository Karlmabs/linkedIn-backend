package com.ams.postservice.mapper;

import com.ams.postservice.dtos.PostLikeDto;
import com.ams.postservice.entities.Post;
import com.ams.postservice.entities.PostLike;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostLikeMapper {
  PostLike toEntity(PostLikeDto postLikeRequestDto);

  @Mapping(target = "postId", expression = "java(mapPost(postLike.getPost()))")
  PostLikeDto toDto(PostLike postLike);

  default Long mapPost(Post post) {
    if (post == null) {
      return null;
    }
    return post.getId();
  }

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  PostLike partialUpdate(PostLikeDto postLikeDto, @MappingTarget PostLike postLike);
}
