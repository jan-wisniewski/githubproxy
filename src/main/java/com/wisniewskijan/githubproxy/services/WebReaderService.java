package com.wisniewskijan.githubproxy.services;

import com.wisniewskijan.githubproxy.dtos.RepositoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class WebReaderService {

    private final RestTemplate restTemplate = new RestTemplate();

    Logger logger = LoggerFactory.getLogger(WebReaderService.class);

   public List<RepositoryDto> readData (String url) {
       logger.info("Enter readData with arguments: {}", url);
       RepositoryDto[] response = restTemplate.getForObject(url, RepositoryDto[].class);
       return Arrays.asList(response);
   }

}
