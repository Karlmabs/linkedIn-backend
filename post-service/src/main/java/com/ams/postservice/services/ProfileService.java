package com.ams.postservice.services;

import com.ams.postservice.dtos.ProfileDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProfileService {

  private final RestTemplate restTemplate;

  public ProfileService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ProfileDto getProfile(Long id) {
    return restTemplate.getForObject("http://localhost:8081/api/profiles/" + id, ProfileDto.class);
  }
}
