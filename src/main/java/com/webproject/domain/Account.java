package com.webproject.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter@Setter@EqualsAndHashCode(of = "id") // 무한 루프 제거
@Builder @AllArgsConstructor @NoArgsConstructor
public class Account {

    @Id@GeneratedValue
    private Long id;

    @Column(unique = true) // 중복 들어가면 안된다.
    private String email;

    @Column(unique = true) // 중복 들어가면 안된다.
    private String nickname;

    private String password;

    private boolean emailVerified; // 이메일 인증이 된 계정인지 아닌지 확인.

    private String emailCheckToken; // 이메일 체크 토큰값

    private LocalDateTime joinedAt; // 가입 날짜 확인

    private String bio; // 자기소개란

    private String url;

    private String occupation;

    private String location; // 살고있는지 //varchar(255)형태로 기록

    @Lob @Basic(fetch = FetchType.EAGER)
    private String profileImage; // varchar의 용량 초과시를 방지하기위해 @Lob을 사용 한다.

    private boolean studyCreatedByEmail;

    private boolean studyCreatedByWeb;

    private boolean studyEnrollmentResultByWeb;

    private boolean studyUpdateByWeb;

    public void generateEmailCheckToken() {
        this.emailCheckToken = UUID.randomUUID().toString();
    }

    public void completeSignUp() {
        this.setEmailVerified(true);
        this.setJoinedAt(LocalDateTime.now());
    }

    public boolean isValidToken(String token) {
        return this.emailCheckToken.equals(token);
    }
}


