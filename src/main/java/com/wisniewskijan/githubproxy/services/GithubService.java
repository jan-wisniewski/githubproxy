package com.wisniewskijan.githubproxy.services;

import com.wisniewskijan.githubproxy.dtos.fetchingData.RepositoryDto;
import com.wisniewskijan.githubproxy.dtos.response.ResponseDto;
import com.wisniewskijan.githubproxy.mappers.ResponseDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class GithubService {

    private WebReaderService webReaderService;
    private ResponseDtoMapper responseDtoMapper;

    public GithubService(WebReaderService webReaderService, ResponseDtoMapper responseDtoMapper) {
        this.webReaderService = webReaderService;
        this.responseDtoMapper = responseDtoMapper;
    }

    Logger logger = LoggerFactory.getLogger(GithubService.class);

    public List<ResponseDto> getAllRepositories(String username) {
        logger.info("Entering getAllRepositories with arguments: {}", username);
        if (Objects.isNull(username) || StringUtils.containsWhitespace(username) || username.equals("")) {
            throw new IllegalArgumentException("Incorrect username");
        }
        return responseDtoMapper.mapToResponseDto(webReaderService.readRepositoriesForUsername(username));
    }

}
