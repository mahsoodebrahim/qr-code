package com.mebrahim.qrcode.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mebrahim.qrcode.models.RandomFact;

@Service
public class RandomFactsService {
  private final RestTemplate restTemplate;

  public RandomFactsService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public RandomFact getRandomFact() {
    String apiUrl = "https://uselessfacts.jsph.pl/api/v2/facts/random";
    return restTemplate.getForObject(apiUrl, RandomFact.class);
  }
}
