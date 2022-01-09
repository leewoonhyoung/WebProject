package com.webproject.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class AccountController {

    @InitBinder("signUpForm")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(signUpFormValidator);
    }

    private final SignUpFormValidator signUpFormValidator;

    @GetMapping("/sign-up")
    public String signUpForm(Model model){
        model.addAttribute("signUpForm", new SignUpForm());
        return "account/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUpSubmit(@Valid @ModelAttribute SignUpForm signUpForm, Errors errors){
        if (errors.hasErrors()){
            return "account/sign-up";
        }

//        signUpFormValidator.validate(signUpForm,errors);
//        if (errors.hasErrors()){
//            return "account/sign-up";
//        }

        //TDDO 회원 가입 처리
        return "redirect:/";


    }// @ModelAttribute 를 사용하여 복합 객체를 가져온다. 닉네임 이메일 패스워드

}
