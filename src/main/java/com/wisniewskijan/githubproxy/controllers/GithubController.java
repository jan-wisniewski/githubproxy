package com.wisniewskijan.githubproxy.controllers;

import com.wisniewskijan.githubproxy.dtos.RepositoryDto;
import com.wisniewskijan.githubproxy.services.GithubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/repositories/{username}")
    public ResponseEntity<List<RepositoryDto>> getAllRepositories(@PathVariable String username) {
        return ResponseEntity.ok(githubService.getAllRepositories(username));
    }

}
