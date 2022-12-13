package com.wisniewskijan.githubproxy.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class ResponseDto {
    private String repositoryName;
    private String ownerLogin;
    private List<BranchResponseDto> branches;
}
