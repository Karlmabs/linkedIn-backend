package com.ams.profileservice.mapper;


import com.ams.profileservice.dtos.EducationDto;
import com.ams.profileservice.entities.Education;
import com.ams.profileservice.entities.Profile;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EducationMapper {

  Education toEntity(EducationDto educationRequestDto);

  @Mapping(target = "profileId", expression = "java(mapProfile(education.getProfile()))")
  EducationDto toDto(Education education);

  default Long mapProfile(Profile profile) {
    if (profile == null) {
      return null;
    }
    return profile.getId();
  }

//  List<EducationDto> toDtoList(List<Education> educations);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Education partialUpdate(EducationDto educationDto, @MappingTarget Education education);
}
