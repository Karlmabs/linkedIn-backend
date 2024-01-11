package com.ams.bff.controllers;

import com.ams.bff.dtos.PostPageDto;
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

@RestController
@RequestMapping("/PostPage")
public class PostPageController {
  private final PostPageService postPageService;

  public PostPageController(PostPageService postPageService) {
    this.postPageService = postPageService;
  }

  @Operation(summary = "Get a post to be displayed")
  @ApiResponse(responseCode = "200", description = "Found the post",
          content = { @Content(mediaType = "application/json",
                  schema = @Schema(implementation = PostPageDto.class)) })
  @GetMapping("/{id}")
  public ResponseEntity<PostPageDto> getAPost(@Parameter(description = "Id of a specific post") @PathVariable("id") int id){
    return ResponseEntity.ok(postPageService.getAPost(id));
  }
}
