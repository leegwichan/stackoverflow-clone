package com.clone.practice.domain.user.dto.request;

import com.clone.practice.domain.user.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberPatchRequest {

    private final String displayName;
    private final String image;
    private final String location;
    private final String memberTitle;
    private final String aboutMe;

    public Member.Updater toUpdater() {
        return Member.Updater.builder()
                .displayName(displayName)
                .image(image)
                .location(location)
                .memberTitle(memberTitle)
                .aboutMe(aboutMe)
                .build();
    }
}
