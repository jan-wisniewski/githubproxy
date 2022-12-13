package com.wisniewskijan.githubproxy.dtos.fetchingData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class RepositoryDto {
    private String name;
    private String fork;
    private OwnerDto owner;
    private List<BranchFetchDto> branches;
}
