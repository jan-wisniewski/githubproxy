package com.wisniewskijan.githubproxy.mappers;

import com.wisniewskijan.githubproxy.dtos.fetchingData.RepositoryDto;
import com.wisniewskijan.githubproxy.dtos.response.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ResponseDtoMapper {

    private BranchDtoMapper branchDtoMapper;

    public ResponseDtoMapper(BranchDtoMapper branchDtoMapper) {
        this.branchDtoMapper = branchDtoMapper;
    }

    public List<ResponseDto> mapToResponseDto(List<RepositoryDto> repositoryDtos) {
        return repositoryDtos.stream().map(this::fromRepositoryDtoToResponseDto).collect(Collectors.toList());
    }

    private ResponseDto fromRepositoryDtoToResponseDto(RepositoryDto repositoryDto) {
        return ResponseDto.builder()
                .repositoryName(repositoryDto.getName())
                .ownerLogin((Objects.nonNull(repositoryDto.getOwner()) ? repositoryDto.getOwner().getLogin() : "-"))
                .branches(branchDtoMapper.fromFetchingDtoListToResponseDtoList(repositoryDto.getBranches()))
                .build();
    }

}
