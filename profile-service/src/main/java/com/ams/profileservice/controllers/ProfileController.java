package com.ams.profileservice.controllers;

import com.ams.profileservice.dtos.ProfileDto;
import com.ams.profileservice.services.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

  @Operation(summary = "Get all profiles")
  @ApiResponse(responseCode = "200", description = "Found the profiles",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ProfileDto.class)) })
  @GetMapping
  public ResponseEntity<List<ProfileDto>> getProfileDtos(){
    return ResponseEntity.ok(profileService.findAll());
  }

  @Operation(summary = "Create a new profiles")
  @ApiResponse(responseCode = "200", description = "ProfileDto created successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ProfileDto.class)) })
  @PostMapping
  public ResponseEntity<ProfileDto> createProfileDto(@RequestBody ProfileDto profilesDto){
    return ResponseEntity.ok(profileService.save(profilesDto));
  }

  @Operation(summary = "Get a profiles by ID")
  @ApiResponse(responseCode = "200", description = "Found the profiles",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ProfileDto.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<ProfileDto> getProfileDtoById(@Parameter(description = "ID of the profiles to be obtained") @PathVariable Long id){
    return ResponseEntity.ok(profileService.findById(id));
  }

  @Operation(summary = "Update a profiles")
  @ApiResponse(responseCode = "200", description = "ProfileDto updated successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ProfileDto.class)) })
  @PutMapping("/{id}")
  public ResponseEntity<ProfileDto> updateProfileDto(@Parameter(description = "ID of the profiles to be updated") @PathVariable Long id,
                                                     @RequestBody ProfileDto profilesDto){
    return ResponseEntity.ok(profileService.update(id, profilesDto));
  }

  @Operation(summary = "Delete a profiles")
  @ApiResponse(responseCode = "204", description = "ProfileDto deleted successfully")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProfileDto(@Parameter(description = "ID of the profiles to be deleted") @PathVariable Long id){
    profileService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Add a connection to a profile")
  @ApiResponse(responseCode = "200", description = "Connection added successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ProfileDto.class)) })
  @PatchMapping("/addConnection/{profileId1}/{profileId2}")
  public ResponseEntity<ProfileDto> addConnection(@Parameter(description = "ID of the first profile") @PathVariable ("profileId1") Long profileId1, @Parameter(description = "ID of the profile second profile") @PathVariable ("profileId2") Long profileId2){
    return ResponseEntity.ok(profileService.addConnection(profileId1, profileId2));
  }

  @Operation(summary = "Remove a connection to a profile")
  @ApiResponse(responseCode = "200", description = "Connection removed successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ProfileDto.class)) })
  @PatchMapping("/removeConnection/{profileId1}/{profileId2}")
  public ResponseEntity<ProfileDto> removeConnection(@Parameter(description = "ID of the first profile") @PathVariable ("profileId1") Long profileId1, @Parameter(description = "ID of the profile second profile") @PathVariable ("profileId2") Long profileId2){
    return ResponseEntity.ok(profileService.removeConnection(profileId1, profileId2));
  }
}
