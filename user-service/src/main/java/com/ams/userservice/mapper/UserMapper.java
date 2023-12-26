package com.ams.userservice.mapper;


import com.ams.userservice.dto.UserDto;
import com.ams.userservice.entities.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

  User toEntity(UserDto userRequestDto);

  UserDto toDto(User user);

//  List<UserDto> toDtoList(List<User> users);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  User partialUpdate(UserDto userDto, @MappingTarget User user);
}
