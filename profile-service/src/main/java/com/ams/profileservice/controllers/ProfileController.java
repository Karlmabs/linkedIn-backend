package com.ams.profileservice.controllers;

import com.ams.profileservice.dtos.ProfileDto;
import com.ams.profileservice.services.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
  public final ProfileService profileService;

  public ProfileController(ProfileService profileService) {
    this.profileService = profileService;
  }

  @GetMapping
  public ResponseEntity<List<ProfileDto>> getProfiles(){
    return ResponseEntity.ok(profileService.findAll());
  }

  @PostMapping
  public ResponseEntity<ProfileDto> createProfile(@RequestBody ProfileDto profileDto){
    return ResponseEntity.ok(profileService.save(profileDto));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProfileDto> getProfileById(Long id){
    return ResponseEntity.ok(profileService.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProfileDto> updateProfile(@PathVariable Long id, @RequestBody ProfileDto profileDto){
    return ResponseEntity.ok(profileService.update(id, profileDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProfile(@PathVariable Long id){
    profileService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
