package com.ams.profileservice.services;

import com.ams.profileservice.dtos.ProfileDto;
import com.ams.profileservice.entities.Profile;
import com.ams.profileservice.exceptions.ResourceNotFoundException;
import com.ams.profileservice.mapper.ProfileMapper;
import com.ams.profileservice.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {
  private final ProfileRepository profileRepository;
  private final ProfileMapper profileMapper;

  public ProfileService(ProfileRepository profileRepository, ProfileMapper profileMapper) {
    this.profileRepository = profileRepository;
    this.profileMapper = profileMapper;
  }

  public List<ProfileDto> findAll(){
    return profileRepository.findAll().stream().map(profileMapper::toDto).collect(Collectors.toList());
  }

  public ProfileDto findById(Long id) {
    return profileMapper.toDto(profileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Profile", "id", id)));
  }

  public ProfileDto save(ProfileDto profileDto) {
    Profile profile = profileMapper.toEntity(profileDto);
    return profileMapper.toDto(profileRepository.save(profile));
  }

  public ProfileDto update(long id, ProfileDto profileDto) {
    Profile profile = profileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Profile", "id", id));
    profile = profileMapper.partialUpdate(profileDto, profile);
    return profileMapper.toDto(profileRepository.save(profile));
  }

  public void delete(Long id) {
    profileRepository.deleteById(id);
  }
}
