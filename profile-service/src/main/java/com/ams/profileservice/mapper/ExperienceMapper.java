package com.ams.profileservice.mapper;


import com.ams.profileservice.dtos.ExperienceDto;
import com.ams.profileservice.entities.Experience;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExperienceMapper {

  Experience toEntity(ExperienceDto experienceRequestDto);

  ExperienceDto toDto(Experience experience);

//  List<ExperienceDto> toDtoList(List<Experience> experiences);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Experience partialUpdate(ExperienceDto experienceDto, @MappingTarget Experience experience);
}
