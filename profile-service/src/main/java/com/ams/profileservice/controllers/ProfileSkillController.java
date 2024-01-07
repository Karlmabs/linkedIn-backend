package com.ams.profileservice.controllers;

import com.ams.profileservice.dtos.ProfileSkillDto;
import com.ams.profileservice.services.ProfileSkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/profileSkills")
public class ProfileSkillController {
  public final ProfileSkillService profileSkillService;

  public ProfileSkillController(ProfileSkillService profileSkillService) {
    this.profileSkillService = profileSkillService;
  }

  @Operation(summary = "Get all profileSkills")
  @ApiResponse(responseCode = "200", description = "Found the profileSkills",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ProfileSkillDto.class)) })
  @GetMapping
  public ResponseEntity<List<ProfileSkillDto>> getProfileSkillDtos(){
    return ResponseEntity.ok(profileSkillService.findAll());
  }

  @Operation(summary = "Create a new profileSkills")
  @ApiResponse(responseCode = "200", description = "ProfileSkillDto created successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ProfileSkillDto.class)) })
  @PostMapping
  public ResponseEntity<ProfileSkillDto> createProfileSkillDto(@RequestBody ProfileSkillDto profileSkillsDto){
    return ResponseEntity.ok(profileSkillService.save(profileSkillsDto));
  }

  @Operation(summary = "Get a profileSkills by ID")
  @ApiResponse(responseCode = "200", description = "Found the profileSkills",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ProfileSkillDto.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<ProfileSkillDto> getProfileSkillDtoById(@Parameter(description = "ID of the profileSkills to be obtained") @PathVariable Long id){
    return ResponseEntity.ok(profileSkillService.findById(id));
  }

  @Operation(summary = "Update a profileSkills")
  @ApiResponse(responseCode = "200", description = "ProfileSkillDto updated successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ProfileSkillDto.class)) })
  @PutMapping("/{id}")
  public ResponseEntity<ProfileSkillDto> updateProfileSkillDto(@Parameter(description = "ID of the profileSkills to be updated") @PathVariable Long id,
                                                     @RequestBody ProfileSkillDto profileSkillsDto){
    return ResponseEntity.ok(profileSkillService.update(id, profileSkillsDto));
  }

  @Operation(summary = "Delete a profileSkills")
  @ApiResponse(responseCode = "204", description = "ProfileSkillDto deleted successfully")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProfileSkillDto(@Parameter(description = "ID of the profileSkills to be deleted") @PathVariable Long id){
    profileSkillService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
