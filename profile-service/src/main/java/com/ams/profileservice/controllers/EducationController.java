package com.ams.profileservice.controllers;

import com.ams.profileservice.dtos.EducationDto;
import com.ams.profileservice.services.EducationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

  @Operation(summary = "Get all educations")
  @ApiResponse(responseCode = "200", description = "Found the educations",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = EducationDto.class)) })
  @GetMapping
  public ResponseEntity<List<EducationDto>> getEducationDtos(){
    return ResponseEntity.ok(educationService.findAll());
  }

  @Operation(summary = "Create a new educations")
  @ApiResponse(responseCode = "200", description = "EducationDto created successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = EducationDto.class)) })
  @PostMapping
  public ResponseEntity<EducationDto> createEducationDto(@RequestBody EducationDto educationsDto){
    return ResponseEntity.ok(educationService.save(educationsDto));
  }

  @Operation(summary = "Get a educations by ID")
  @ApiResponse(responseCode = "200", description = "Found the educations",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = EducationDto.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<EducationDto> getEducationDtoById(@Parameter(description = "ID of the educations to be obtained") @PathVariable Long id){
    return ResponseEntity.ok(educationService.findById(id));
  }

  @Operation(summary = "Update a educations")
  @ApiResponse(responseCode = "200", description = "EducationDto updated successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = EducationDto.class)) })
  @PutMapping("/{id}")
  public ResponseEntity<EducationDto> updateEducationDto(@Parameter(description = "ID of the educations to be updated") @PathVariable Long id,
                                                         @RequestBody EducationDto educationsDto){
    return ResponseEntity.ok(educationService.update(id, educationsDto));
  }

  @Operation(summary = "Delete a educations")
  @ApiResponse(responseCode = "204", description = "EducationDto deleted successfully")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEducationDto(@Parameter(description = "ID of the educations to be deleted") @PathVariable Long id){
    educationService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
