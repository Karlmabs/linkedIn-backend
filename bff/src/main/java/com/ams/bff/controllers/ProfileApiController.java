package com.ams.bff.controllers;

import com.ams.bff.dtos.ProfileApiDto;
import com.ams.bff.services.ProfileApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ProfileApi")
public class ProfileApiController {

    private final ProfileApiService profileApiService;

  public ProfileApiController(ProfileApiService profileApiService) {
    this.profileApiService = profileApiService;
  }

  @Operation(summary = "Get all the profiles associated with a user")
  @ApiResponse(responseCode = "200", description = "Found the profiles",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = ProfileApiDto.class)) })
  @GetMapping("/user/{userId}")
  public ResponseEntity<ProfileApiDto> getUserProfile(@Parameter(description = "ID of the user") @PathVariable("userId") Long userId){
    return ResponseEntity.ok(profileApiService.getProfileFromId(userId));
  }
}
