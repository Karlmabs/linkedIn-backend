package com.ams.bff.controllers;

import com.ams.bff.dtos.HomePostDto;
import com.ams.bff.dtos.PostDto;
import com.ams.bff.dtos.PostPageDto;
import com.ams.bff.services.HomePageService;
import com.ams.bff.services.PostPageService;
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

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomePageController {

  private final HomePageService homePageService;

  public HomePageController(HomePageService homePageService) {
    this.homePageService = homePageService;
  }

  @Operation(summary = "Get all Posts for the home page")
  @ApiResponse(responseCode = "200", description = "Found the posts",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = HomePostDto[].class)) })
  @GetMapping("/{N}")
  public ResponseEntity<List<HomePostDto>> getAllPosts(@Parameter(description = "number of characters to retrieve for content") @PathVariable("N") int N){
    return ResponseEntity.ok(homePageService.getHomePosts(N));
  }


}
