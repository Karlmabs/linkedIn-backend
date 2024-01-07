package com.ams.profileservice.services;

import com.ams.profileservice.dtos.ExperienceDto;
import com.ams.profileservice.entities.Experience;
import com.ams.profileservice.exceptions.ResourceNotFoundException;
import com.ams.profileservice.mapper.ExperienceMapper;
import com.ams.profileservice.repositories.ExperienceRepository;
import com.ams.profileservice.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceService {
  private final ExperienceRepository experienceRepository;
  private final ExperienceMapper experienceMapper;

  private final ProfileRepository profileRepository;

  public ExperienceService(ExperienceRepository experienceRepository, ExperienceMapper experienceMapper, ProfileRepository profileRepository) {
    this.experienceRepository = experienceRepository;
    this.experienceMapper = experienceMapper;
    this.profileRepository = profileRepository;
  }

  public List<ExperienceDto> findAll(){
    return experienceRepository.findAll().stream().map(experienceMapper::toDto).collect(Collectors.toList());
  }

  public ExperienceDto findById(Long id) {
    return experienceMapper.toDto(experienceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Experience", "id", id)));
  }

  public ExperienceDto save(ExperienceDto experienceDto) {
    Experience experience = experienceMapper.toEntity(experienceDto);
    System.out.println("ExperienceDto: " + experienceDto);
    System.out.println("Experience: " + experience);
    experience.setProfile(profileRepository.findById(experienceDto.getProfileId()).orElseThrow(() -> new ResourceNotFoundException("Profile", "id", experienceDto.getProfileId())));
    return experienceMapper.toDto(experienceRepository.save(experience));
  }

  public ExperienceDto update(long id, ExperienceDto experienceDto) {
    Experience experience = experienceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Experience", "id", id));
    experience = experienceMapper.partialUpdate(experienceDto, experience);
    experience.setProfile(profileRepository.findById(experienceDto.getProfileId()).orElseThrow(() -> new ResourceNotFoundException("Profile", "id", experienceDto.getProfileId())));
    return experienceMapper.toDto(experienceRepository.save(experience));
  }

  public void delete(Long id) {
    experienceRepository.deleteById(id);
  }
}
