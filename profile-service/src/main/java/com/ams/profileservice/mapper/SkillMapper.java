package com.ams.profileservice.mapper;

import com.ams.profileservice.dtos.ProfileDto;
import com.ams.profileservice.dtos.SkillDto;
import com.ams.profileservice.entities.Profile;
import com.ams.profileservice.entities.ProfileSkill;
import com.ams.profileservice.entities.Skill;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SkillMapper {
  @Mapping(target = "profileSkills", ignore = true)
  Skill toEntity(SkillDto skillRequestDto);

  @Mapping(target = "profileSkills", expression = "java(mapProfileSkills(skill.getProfileSkills()))")
  SkillDto toDto(Skill skill);

  default List<Long> mapProfileSkills(List<ProfileSkill> profileSkills) {
    if (profileSkills == null) {
      return null;
    }
    return profileSkills.stream().map(ProfileSkill::getId).collect(java.util.stream.Collectors.toList());
  }

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(target = "profileSkills", ignore = true)
  Skill partialUpdate(SkillDto skillDto, @MappingTarget Skill skill);
}
