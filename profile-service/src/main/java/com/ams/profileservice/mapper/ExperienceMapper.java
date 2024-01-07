package com.ams.profileservice.mapper;


import com.ams.profileservice.dtos.ExperienceDto;
import com.ams.profileservice.entities.Experience;
import com.ams.profileservice.entities.Profile;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExperienceMapper {

  Experience toEntity(ExperienceDto experienceRequestDto);

  @Mapping(target = "profileId", expression = "java(mapProfile(experience.getProfile()))")
  ExperienceDto toDto(Experience experience);

  default Long mapProfile(Profile profile) {
    if (profile == null) {
      return null;
    }
    return profile.getId();
  }

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Experience partialUpdate(ExperienceDto experienceDto, @MappingTarget Experience experience);
}
