package com.ams.profileservice.services;

import com.ams.profileservice.dtos.ProfileDto;
import com.ams.profileservice.entities.Profile;
import com.ams.profileservice.exceptions.ResourceNotFoundException;
import com.ams.profileservice.mapper.ProfileMapper;
import com.ams.profileservice.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

  public ProfileDto addConnection(Long profileId1, Long profileId2) {
    Profile profile1 = profileRepository.findById(profileId1).orElseThrow(() -> new ResourceNotFoundException("Profile", "id", profileId1));
    Profile profile2 = profileRepository.findById(profileId2).orElseThrow(() -> new ResourceNotFoundException("Profile", "id", profileId2));

    Set<Profile> connections1 = new HashSet<>();
    connections1.add(profile2);
    profile1.setConnections(connections1);

    Set<Profile> connections2 = new HashSet<>();
    connections2.add(profile1);
    profile2.setConnections(connections2);

    profileRepository.save(profile1);
    profileRepository.save(profile2);

    return profileMapper.toDto(profile1);
  }

  public ProfileDto removeConnection(Long profileId1, Long profileId2) {
    Profile profile1 = profileRepository.findById(profileId1).orElseThrow(() -> new ResourceNotFoundException("Profile", "id", profileId1));
    Profile profile2 = profileRepository.findById(profileId2).orElseThrow(() -> new ResourceNotFoundException("Profile", "id", profileId2));

    Set<Profile> connections1 = new HashSet<>(profile1.getConnections());
    connections1.remove(profile2);
    profile1.setConnections(connections1);

    Set<Profile> connections2 = new HashSet<>(profile2.getConnections());
    connections2.remove(profile1);
    profile2.setConnections(connections2);

    profileRepository.save(profile1);
    profileRepository.save(profile2);

    return profileMapper.toDto(profile1);
  }
}
