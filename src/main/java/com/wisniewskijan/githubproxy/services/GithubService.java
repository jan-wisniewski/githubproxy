package com.wisniewskijan.githubproxy.services;

import com.wisniewskijan.githubproxy.dtos.RepositoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class GithubService {

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
        return webReaderService.readRepositoriesForUsername(username);
    }

}
