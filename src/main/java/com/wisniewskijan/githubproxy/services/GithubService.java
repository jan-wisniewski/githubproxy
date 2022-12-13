package com.wisniewskijan.githubproxy.services;

import com.wisniewskijan.githubproxy.dtos.RepositoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GithubService {

    @Value("${config.url.repositories.start-part}")
    private String repositoryUrlStartPart;

    @Value("${config.url.repositories.end-part}")
    private String repositoryUrlEndPart;

    private WebReaderService webReaderService;

    public GithubService(WebReaderService webReaderService) {
        this.webReaderService = webReaderService;
    }

    Logger logger = LoggerFactory.getLogger(GithubService.class);

    public List<RepositoryDto> getAllRepositories(String username) {
        logger.info("Entering getAllRepositories with arguments: {}", username);
        if (Objects.isNull(username) || StringUtils.containsWhitespace(username) || username.equals("")) {
            throw new IllegalArgumentException("Incorrect username");
        }
        return webReaderService.readData(repositoryUrlStartPart + username + repositoryUrlEndPart);
    }

}
