package com.wisniewskijan.githubproxy.dtos.fetchingData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class OwnerDto {
    private String login;
}
