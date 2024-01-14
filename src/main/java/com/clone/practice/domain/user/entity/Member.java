package com.clone.practice.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(nullable = false, length = 30)
    private String displayName;

    @Column(length = 1000)
    private String image;

    @Column(length = 100)
    private String location;

    @Column(length = 100)
    private String memberTitle;

    @Column(length = 1000)
    private String aboutMe;

    @Column
    private boolean deleted = false;

    @Column
    @Enumerated(EnumType.STRING)
    private MemberRole role = MemberRole.USER;

    public void update(Updater updater) {
        this.displayName = updater.getDisplayName();
        this.image = updater.getImage();
        this.location = updater.getLocation();
        this.memberTitle = updater.getMemberTitle();
        this.aboutMe = updater.getAboutMe();
    }

    @Builder(access = AccessLevel.PUBLIC)
    private Member(String email, String password, String displayName) {
        this.email = email;
        this.password = password;
        this.displayName = displayName;
    }

    @Getter(value = AccessLevel.PRIVATE)
    @AllArgsConstructor
    @Builder(access = AccessLevel.PUBLIC)
    public class Updater {
        private String displayName;
        private String image;
        private String location;
        private String memberTitle;
        private String aboutMe;
    }

    private enum MemberRole {
        USER, ADMIN
    }
}
