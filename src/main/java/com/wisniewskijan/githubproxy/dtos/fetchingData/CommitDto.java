package com.wisniewskijan.githubproxy.dtos.fetchingData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CommitDto {
    private String sha;
    private String url;
}
