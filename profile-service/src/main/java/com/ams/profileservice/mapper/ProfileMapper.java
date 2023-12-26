package com.ams.profileservice.mapper;


import com.ams.profileservice.dtos.ProfileDto;
import com.ams.profileservice.entities.Profile;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {

  Profile toEntity(ProfileDto profileRequestDto);

  ProfileDto toDto(Profile profile);

//  List<ProfileDto> toDtoList(List<Profile> profiles);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Profile partialUpdate(ProfileDto profileDto, @MappingTarget Profile profile);
}
