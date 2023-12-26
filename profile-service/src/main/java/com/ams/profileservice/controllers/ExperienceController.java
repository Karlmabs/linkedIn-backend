package com.ams.profileservice.controllers;

import com.ams.profileservice.dtos.ExperienceDto;
import com.ams.profileservice.services.ExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
public class ExperienceController {
  public final ExperienceService experienceService;

  public ExperienceController(ExperienceService experienceService) {
    this.experienceService = experienceService;
  }

  @GetMapping
  public ResponseEntity<List<ExperienceDto>> getExperiences(){
    return ResponseEntity.ok(experienceService.findAll());
  }

  @PostMapping
  public ResponseEntity<ExperienceDto> createExperience(@RequestBody ExperienceDto experienceDto){
    return ResponseEntity.ok(experienceService.save(experienceDto));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ExperienceDto> getExperienceById(Long id){
    return ResponseEntity.ok(experienceService.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ExperienceDto> updateExperience(@PathVariable Long id, @RequestBody ExperienceDto experienceDto){
    return ResponseEntity.ok(experienceService.update(id, experienceDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteExperience(@PathVariable Long id){
    experienceService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
