package com.studyolle.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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
}


