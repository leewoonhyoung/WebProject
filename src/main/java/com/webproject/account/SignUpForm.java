package com.webproject.account;

import lombok.Data;

@Data
public class SignUpForm {
    //회원 가입시 받아올 데이터

    private String nickname;

    private String email;

    private String password;


}
