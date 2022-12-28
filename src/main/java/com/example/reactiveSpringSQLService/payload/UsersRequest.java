package com.example.reactiveSpringSQLService.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class UsersRequest {
    private String username;
    private String name;
    private String email;
    private String phoneNumber;
}
