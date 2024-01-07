package com.ams.profileservice.services;

import com.ams.profileservice.dtos.ProfileSkillDto;
import com.ams.profileservice.entities.ProfileSkill;
import com.ams.profileservice.exceptions.ResourceNotFoundException;
import com.ams.profileservice.mapper.ProfileSkillMapper;
import com.ams.profileservice.repositories.ProfileRepository;
import com.ams.profileservice.repositories.ProfileSkillRepository;
import com.ams.profileservice.repositories.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileSkillService {
  private final ProfileSkillRepository profileSkillRepository;
  private final ProfileSkillMapper profileSkillMapper;

  private final ProfileRepository profileRepository;

  private final SkillRepository skillRepository;

  public ProfileSkillService(ProfileSkillRepository profileSkillRepository, ProfileSkillMapper profileSkillMapper, ProfileRepository profileRepository, SkillRepository skillRepository) {
    this.profileSkillRepository = profileSkillRepository;
    this.profileSkillMapper = profileSkillMapper;
    this.profileRepository = profileRepository;
    this.skillRepository = skillRepository;
  }

  public List<ProfileSkillDto> findAll(){
    return profileSkillRepository.findAll().stream().map(profileSkillMapper::toDto).collect(Collectors.toList());
  }

  public ProfileSkillDto findById(Long id) {
    return profileSkillMapper.toDto(profileSkillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProfileSkill", "id", id)));
  }

  public ProfileSkillDto save(ProfileSkillDto profileSkillDto) {
    ProfileSkill profileSkill = profileSkillMapper.toEntity(profileSkillDto);
    profileSkill.setProfile(profileRepository.findById(profileSkillDto.getProfileId()).orElseThrow(() -> new ResourceNotFoundException("Profile", "id", profileSkillDto.getProfileId())));
    profileSkill.setSkill(skillRepository.findById(profileSkillDto.getSkillId()).orElseThrow(() -> new ResourceNotFoundException("Skill", "id", profileSkillDto.getSkillId())));
    return profileSkillMapper.toDto(profileSkillRepository.save(profileSkill));
  }

  public ProfileSkillDto update(long id, ProfileSkillDto profileSkillDto) {
    ProfileSkill profileSkill = profileSkillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProfileSkill", "id", id));
    profileSkill = profileSkillMapper.partialUpdate(profileSkillDto, profileSkill);
    profileSkill.setProfile(profileRepository.findById(profileSkillDto.getProfileId()).orElseThrow(() -> new ResourceNotFoundException("Profile", "id", profileSkillDto.getProfileId())));
    profileSkill.setSkill(skillRepository.findById(profileSkillDto.getSkillId()).orElseThrow(() -> new ResourceNotFoundException("Skill", "id", profileSkillDto.getSkillId())));
    return profileSkillMapper.toDto(profileSkillRepository.save(profileSkill));
  }

  public void delete(Long id) {
    profileSkillRepository.deleteById(id);
  }
}
