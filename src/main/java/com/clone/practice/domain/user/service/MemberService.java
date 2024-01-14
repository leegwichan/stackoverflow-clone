package com.clone.practice.domain.user.service;

import com.clone.practice.domain.user.dto.request.MemberPatchRequest;
import com.clone.practice.domain.user.dto.request.MemberPostRequest;
import com.clone.practice.domain.user.dto.response.MemberPageResponse;
import com.clone.practice.domain.user.dto.response.MemberResponse;
import com.clone.practice.domain.user.entity.Member;
import com.clone.practice.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse getMember(final long memberId) {
        Member member = findMember(memberId);
        return MemberResponse.from(member);
    }

    public MemberPageResponse getMemberPage(final long memberId) {
        Member member = findMember(memberId);
        return MemberPageResponse.from(member);
    }

    public MemberResponse signIn(final MemberPostRequest request) {
        checkDuplicatedEmail(request.getEmail());

        Member savedMember = memberRepository.save(request.toEntity());

        return MemberResponse.from(savedMember);
    }

    public MemberResponse update(final long memberId, final MemberPatchRequest request) {
        Member member = findMember(memberId);

        member.update(request.toUpdater());
        Member savedMember = memberRepository.save(member);

        return MemberResponse.from(savedMember);
    }

    public Member findMember(long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 존재하지 않습니다"));
    }

    private void checkDuplicatedEmail(String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("해당 이메일은 이미 사용중입니다");
        }
    }
}

