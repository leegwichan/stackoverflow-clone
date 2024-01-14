package com.clone.practice.domain.user.dto.response;

import com.clone.practice.domain.user.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponse {

    private Long memberId;
    private String email;
    private String displayName;
    private String image;

    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getMemberId(), member.getEmail(), member.getDisplayName(), member.getImage());
    }
}
