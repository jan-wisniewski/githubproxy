package com.wisniewskijan.githubproxy.mappers;

import com.wisniewskijan.githubproxy.dtos.fetchingData.BranchFetchDto;
import com.wisniewskijan.githubproxy.dtos.fetchingData.CommitDto;
import com.wisniewskijan.githubproxy.dtos.response.BranchResponseDto;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BranchDtoMapper {

    public List<BranchResponseDto> fromFetchingDtoListToResponseDtoList(List<BranchFetchDto> branchFetchDtoList) {
        return branchFetchDtoList.stream().map(this::fromFetchingDtoToResponseDto).collect(Collectors.toList());
    }

    private BranchResponseDto fromFetchingDtoToResponseDto (BranchFetchDto branchFetchDto) {
        if (Objects.isNull(branchFetchDto)) {
            throw new IllegalArgumentException("Branch Fetch Dto is null");
        }
        CommitDto lastCommit = branchFetchDto.getCommit();
        return new BranchResponseDto(branchFetchDto.getName(), lastCommit.getSha());
    }

}
