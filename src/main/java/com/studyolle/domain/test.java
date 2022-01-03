package com.studyolle.domain;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@ToString(exclude = "id")
public class test {

    private String id;
    private String passward;


    test.setId("id");
    test.setPassword("password")

    // test( password = password)

}


