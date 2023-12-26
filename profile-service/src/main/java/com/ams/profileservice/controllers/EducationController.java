package com.ams.profileservice.controllers;

import com.ams.profileservice.dtos.EducationDto;
import com.ams.profileservice.services.EducationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationController {
  public final EducationService educationService;

  public EducationController(EducationService educationService) {
    this.educationService = educationService;
  }

  @GetMapping
  public ResponseEntity<List<EducationDto>> getEducations(){
    return ResponseEntity.ok(educationService.findAll());
  }

  @PostMapping
  public ResponseEntity<EducationDto> createEducation(@RequestBody EducationDto educationDto){
    return ResponseEntity.ok(educationService.save(educationDto));
  }

  @GetMapping("/{id}")
  public ResponseEntity<EducationDto> getEducationById(Long id){
    return ResponseEntity.ok(educationService.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<EducationDto> updateEducation(@PathVariable Long id, @RequestBody EducationDto educationDto){
    return ResponseEntity.ok(educationService.update(id, educationDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEducation(@PathVariable Long id){
    educationService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
