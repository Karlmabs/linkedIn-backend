package com.ams.profileservice.controllers;

import com.ams.profileservice.dtos.ExperienceDto;
import com.ams.profileservice.services.ExperienceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

  @Operation(summary = "Get all experiences")
  @ApiResponse(responseCode = "200", description = "Found the experiences",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ExperienceDto.class)) })
  @GetMapping
  public ResponseEntity<List<ExperienceDto>> getExperienceDtos(){
    return ResponseEntity.ok(experienceService.findAll());
  }

  @Operation(summary = "Create a new experiences")
  @ApiResponse(responseCode = "200", description = "ExperienceDto created successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ExperienceDto.class)) })
  @PostMapping
  public ResponseEntity<ExperienceDto> createExperienceDto(@RequestBody ExperienceDto experiencesDto){
    return ResponseEntity.ok(experienceService.save(experiencesDto));
  }

  @Operation(summary = "Get a experiences by ID")
  @ApiResponse(responseCode = "200", description = "Found the experiences",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ExperienceDto.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<ExperienceDto> getExperienceDtoById(@Parameter(description = "ID of the experiences to be obtained") @PathVariable Long id){
    return ResponseEntity.ok(experienceService.findById(id));
  }

  @Operation(summary = "Update a experiences")
  @ApiResponse(responseCode = "200", description = "ExperienceDto updated successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ExperienceDto.class)) })
  @PutMapping("/{id}")
  public ResponseEntity<ExperienceDto> updateExperienceDto(@Parameter(description = "ID of the experiences to be updated") @PathVariable Long id,
                                                           @RequestBody ExperienceDto experiencesDto){
    return ResponseEntity.ok(experienceService.update(id, experiencesDto));
  }

  @Operation(summary = "Delete a experiences")
  @ApiResponse(responseCode = "204", description = "ExperienceDto deleted successfully")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteExperienceDto(@Parameter(description = "ID of the experiences to be deleted") @PathVariable Long id){
    experienceService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
