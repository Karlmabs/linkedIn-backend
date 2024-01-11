package com.ams.bff.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserApiService {

  private final RestTemplate restTemplate;

  public UserApiService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }


}
