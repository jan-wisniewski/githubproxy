package com.wisniewskijan.githubproxy.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RequestDto {
    private String username;
    private String bearerToken;
}
