package com.wisniewskijan.githubproxy.controllers;

import com.wisniewskijan.githubproxy.config.aop.annotations.Restrict;
import com.wisniewskijan.githubproxy.dtos.fetchingData.RepositoryDto;
import com.wisniewskijan.githubproxy.dtos.response.ResponseDto;
import com.wisniewskijan.githubproxy.services.GithubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @Restrict(isProperHeader = true)
    @GetMapping("/repositories/{username}")
    public ResponseEntity<List<ResponseDto>> getAllRepositories(@PathVariable String username) {
        return ResponseEntity.ok(githubService.getAllRepositories(username));
    }

}
