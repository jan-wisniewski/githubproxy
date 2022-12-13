package com.wisniewskijan.githubproxy.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class BranchResponseDto {
    private String name;
    private String lastCommitSha;
}
