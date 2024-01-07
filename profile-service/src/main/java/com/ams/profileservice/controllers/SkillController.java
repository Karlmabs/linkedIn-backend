package com.ams.profileservice.controllers;

import com.ams.profileservice.dtos.SkillDto;
import com.ams.profileservice.services.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
  public final SkillService skillService;

  public SkillController(SkillService skillService) {
    this.skillService = skillService;
  }

  @Operation(summary = "Get all skills")
  @ApiResponse(responseCode = "200", description = "Found the skills",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = SkillDto.class)) })
  @GetMapping
  public ResponseEntity<List<SkillDto>> getSkillDtos(){
    return ResponseEntity.ok(skillService.findAll());
  }

  @Operation(summary = "Create a new skills")
  @ApiResponse(responseCode = "200", description = "SkillDto created successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = SkillDto.class)) })
  @PostMapping
  public ResponseEntity<SkillDto> createSkillDto(@RequestBody SkillDto skillsDto){
    return ResponseEntity.ok(skillService.save(skillsDto));
  }

  @Operation(summary = "Get a skills by ID")
  @ApiResponse(responseCode = "200", description = "Found the skills",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = SkillDto.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<SkillDto> getSkillDtoById(@Parameter(description = "ID of the skills to be obtained") @PathVariable Long id){
    return ResponseEntity.ok(skillService.findById(id));
  }

  @Operation(summary = "Update a skills")
  @ApiResponse(responseCode = "200", description = "SkillDto updated successfully",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = SkillDto.class)) })
  @PutMapping("/{id}")
  public ResponseEntity<SkillDto> updateSkillDto(@Parameter(description = "ID of the skills to be updated") @PathVariable Long id,
                                                     @RequestBody SkillDto skillsDto){
    return ResponseEntity.ok(skillService.update(id, skillsDto));
  }

  @Operation(summary = "Delete a skills")
  @ApiResponse(responseCode = "204", description = "SkillDto deleted successfully")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSkillDto(@Parameter(description = "ID of the skills to be deleted") @PathVariable Long id){
    skillService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
