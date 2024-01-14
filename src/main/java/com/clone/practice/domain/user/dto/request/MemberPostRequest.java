package com.clone.practice.domain.user.dto.request;

import com.clone.practice.domain.user.entity.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberPostRequest {

    private final String email;
    private final String password;
    private final String displayName;

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .displayName(displayName)
                .build();
    }
}
