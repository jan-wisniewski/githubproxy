package com.wisniewskijan.githubproxy.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class BranchDto {
    private String name;
    private CommitDto commit;
}
