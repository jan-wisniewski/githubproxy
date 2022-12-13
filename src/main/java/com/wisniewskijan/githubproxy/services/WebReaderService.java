package com.wisniewskijan.githubproxy.services;

import com.wisniewskijan.githubproxy.dtos.fetchingData.BranchFetchDto;
import com.wisniewskijan.githubproxy.dtos.fetchingData.RepositoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class WebReaderService {

    @Value("${config.url.repositories.start-part}")
    private String repositoryUrlStartPart;

    @Value("${config.url.repositories.end-part}")
    private String repositoryUrlEndPart;

    @Value("${config.url.branches.start-part}")
    private String branchUrlStartPart;

    @Value("${config.url.branches.end-part}")
    private String branchUrlEndPart;

    private final RestTemplate restTemplate = new RestTemplate();

    Logger logger = LoggerFactory.getLogger(WebReaderService.class);

    public List<RepositoryDto> readRepositoriesForUsername(String username) {
        logger.info("Enter readData with arguments: {}", username);
        RepositoryDto[] response = restTemplate.getForObject(repositoryUrlStartPart + username + repositoryUrlEndPart, RepositoryDto[].class);
        if (Objects.nonNull(response)) {
            Arrays.stream(response).filter(e -> e.getFork().equals("false")).forEach(e -> e.setBranches(readBranchesForRepository(username, e.getName())));
            return Arrays.asList(response);
        } else {
            logger.info("Response for url is null");
            return new ArrayList<>();
        }
    }

    private List<BranchFetchDto> readBranchesForRepository(String username, String repositoryName) {
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(branchUrlStartPart + username + "/" + repositoryName + branchUrlEndPart, BranchFetchDto[].class)));
    }

}
