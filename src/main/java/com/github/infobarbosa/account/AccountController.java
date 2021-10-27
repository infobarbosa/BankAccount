package com.github.infobarbosa.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/account")
public class AccountController {

    @GetMapping("/account")
    public String index(){
        return "meu primeiro rest controller";
    }
}
