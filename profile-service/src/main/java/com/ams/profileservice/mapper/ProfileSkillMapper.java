package com.ams.profileservice.mapper;

import com.ams.profileservice.dtos.ProfileSkillDto;
import com.ams.profileservice.entities.Profile;
import com.ams.profileservice.entities.ProfileSkill;
import com.ams.profileservice.entities.Skill;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileSkillMapper {
  ProfileSkill toEntity(ProfileSkillDto profileSkillRequestDto);

  @Mapping(target = "profileId", expression = "java(mapProfile(profileSkill.getProfile()))")
  @Mapping(target = "skillId", expression = "java(mapSkill(profileSkill.getSkill()))")
  ProfileSkillDto toDto(ProfileSkill profileSkill);

  default Long mapProfile(Profile profile) {
    if (profile == null) {
      return null;
    }
    return profile.getId();
  }

  default Long mapSkill(Skill skill) {
    if (skill == null) {
      return null;
    }
    return skill.getId();
  }

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  ProfileSkill partialUpdate(ProfileSkillDto profileSkillDto, @MappingTarget ProfileSkill profileSkill);
}
