package com.ams.profileservice.mapper;


import com.ams.profileservice.dtos.EducationDto;
import com.ams.profileservice.entities.Education;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EducationMapper {

  Education toEntity(EducationDto educationRequestDto);

  EducationDto toDto(Education education);

//  List<EducationDto> toDtoList(List<Education> educations);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Education partialUpdate(EducationDto educationDto, @MappingTarget Education education);
}
