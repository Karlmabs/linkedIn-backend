package com.ams.profileservice.mapper;


import com.ams.profileservice.dtos.ProfileDto;
import com.ams.profileservice.entities.Profile;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {EducationMapper.class, ExperienceMapper.class, ProfileSkillMapper.class})
public interface ProfileMapper {

  @Mapping(target = "connections", ignore = true)
  Profile toEntity(ProfileDto profileRequestDto);

  @Mapping(target = "connections", expression = "java(mapConnections(profile.getConnections()))")
  ProfileDto toDto(Profile profile);

  default Set<Long> mapConnections(Set<Profile> profiles) {
    if (profiles == null) {
      return null;
    }
    return profiles.stream().map(Profile::getId).collect(Collectors.toSet());
  }

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(target = "connections", ignore = true)
  Profile partialUpdate(ProfileDto profileDto, @MappingTarget Profile profile);
}
