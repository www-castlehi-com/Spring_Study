package io.security.springsecuritymaster;

import java.util.concurrent.Callable;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public User user(@AuthenticationPrincipal User user){
        return user;
    }

    @GetMapping("/db")
    public String db(){
        return "db";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

}