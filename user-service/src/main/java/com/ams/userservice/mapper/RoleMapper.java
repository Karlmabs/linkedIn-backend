package com.ams.userservice.mapper;

import com.ams.userservice.dto.RoleDto;
import com.ams.userservice.entities.Role;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
  Role toEntity(RoleDto roleDto);

  RoleDto toDto(Role role);

  List<RoleDto> toDtoList(List<Role> roles);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Role partialUpdate(RoleDto roleDto, @MappingTarget Role role);
}
