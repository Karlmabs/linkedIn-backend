package com.ams.bff.services;

import com.ams.bff.dtos.ProfileApiDto;
import com.ams.bff.dtos.ProfileDto;
import com.ams.bff.dtos.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProfileApiService {

  private final RestTemplate restTemplate;
  private final HomePageService homePageService;

  public ProfileApiService(RestTemplate restTemplate, HomePageService homePageService) {
    this.restTemplate = restTemplate;
    this.homePageService = homePageService;
  }

  public ProfileApiDto getProfileFromId(long userId) {
    ProfileDto profileDto = restTemplate.getForObject("http://profile-service:8081/profiles/user/" + userId, ProfileDto.class);

    UserDto user = homePageService.getUser(profileDto.getUserId());

    return ProfileApiDto.builder()
        .id(profileDto.getId())
        .currentJobTitle(profileDto.getCurrentJobTitle())
        .industry(profileDto.getIndustry())
        .summary(profileDto.getSummary())
        .headline(profileDto.getHeadline())
        .website(profileDto.getWebsite())
        .openForWork(profileDto.getOpenForWork())
        .education(profileDto.getEducation())
        .experiences(profileDto.getExperiences())
        .skills(profileDto.getSkills())
        .connections(profileDto.getConnections())
        .username(user.getUsername())
        .email(user.getEmail())
        .build();

  }
}
