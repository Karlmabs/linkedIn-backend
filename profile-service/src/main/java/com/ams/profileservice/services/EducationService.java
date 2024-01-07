package com.ams.profileservice.services;

import com.ams.profileservice.dtos.EducationDto;
import com.ams.profileservice.entities.Education;
import com.ams.profileservice.exceptions.ResourceNotFoundException;
import com.ams.profileservice.mapper.EducationMapper;
import com.ams.profileservice.repositories.EducationRepository;
import com.ams.profileservice.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {
  private final EducationRepository educationRepository;
  private final EducationMapper educationMapper;

  private final ProfileRepository profileRepository;

  public EducationService(EducationRepository educationRepository, EducationMapper educationMapper, ProfileRepository profileRepository) {
    this.educationRepository = educationRepository;
    this.educationMapper = educationMapper;
    this.profileRepository = profileRepository;
  }

  public List<EducationDto> findAll(){
    return educationRepository.findAll().stream().map(educationMapper::toDto).collect(Collectors.toList());
  }

  public EducationDto findById(Long id) {
    return educationMapper.toDto(educationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Education", "id", id)));
  }

  public EducationDto save(EducationDto educationDto) {
    Education education = educationMapper.toEntity(educationDto);
    education.setProfile(profileRepository.findById(educationDto.getProfileId()).orElseThrow(() -> new ResourceNotFoundException("Profile", "id", educationDto.getProfileId())));
    return educationMapper.toDto(educationRepository.save(education));
  }

  public EducationDto update(long id, EducationDto educationDto) {
    Education education = educationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Education", "id", id));
    education = educationMapper.partialUpdate(educationDto, education);
    education.setProfile(profileRepository.findById(educationDto.getProfileId()).orElseThrow(() -> new ResourceNotFoundException("Profile", "id", educationDto.getProfileId())));
    return educationMapper.toDto(educationRepository.save(education));
  }

  public void delete(Long id) {
    educationRepository.deleteById(id);
  }
}
