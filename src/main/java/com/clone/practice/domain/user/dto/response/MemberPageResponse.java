package com.clone.practice.domain.user.dto.response;

import com.clone.practice.domain.user.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberPageResponse {

    private Long memberId;
    private String email;
    private String displayName;
    private String image;
    private String location;
    private String memberTitle;
    private String aboutMe;

    public static MemberPageResponse from(Member member) {
        return new MemberPageResponse(member.getMemberId(), member.getEmail(), member.getDisplayName(),
                member.getImage(), member.getLocation(), member.getMemberTitle(), member.getAboutMe());
    }
}
