package com.ams.profileservice.services;

import com.ams.profileservice.dtos.SkillDto;
import com.ams.profileservice.entities.Skill;
import com.ams.profileservice.exceptions.ResourceNotFoundException;
import com.ams.profileservice.mapper.SkillMapper;
import com.ams.profileservice.repositories.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {
  private final SkillRepository skillRepository;
  private final SkillMapper skillMapper;

  public SkillService(SkillRepository skillRepository, SkillMapper skillMapper) {
    this.skillRepository = skillRepository;
    this.skillMapper = skillMapper;
  }

  public List<SkillDto> findAll(){
    return skillRepository.findAll().stream().map(skillMapper::toDto).collect(Collectors.toList());
  }

  public SkillDto findById(Long id) {
    return skillMapper.toDto(skillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id)));
  }

  public SkillDto save(SkillDto skillDto) {
    Skill skill = skillMapper.toEntity(skillDto);
    return skillMapper.toDto(skillRepository.save(skill));
  }

  public SkillDto update(long id, SkillDto skillDto) {
    Skill skill = skillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));
    skill = skillMapper.partialUpdate(skillDto, skill);
    return skillMapper.toDto(skillRepository.save(skill));
  }

  public void delete(Long id) {
    skillRepository.deleteById(id);
  }
}
