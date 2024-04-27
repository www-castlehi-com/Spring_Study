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

    private final AsyncService asyncService;

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

    @GetMapping("/callable")
    public Callable<Authentication> call(){
        SecurityContext securityContext = SecurityContextHolder.getContextHolderStrategy().getContext();
        System.out.println("securityContext = " + securityContext);
        System.out.println("Parent Thread : " + Thread.currentThread().getName());

        return new Callable<Authentication>() {
            @Override
            public Authentication call() throws Exception {
                SecurityContext securityContext = SecurityContextHolder.getContextHolderStrategy().getContext();
                System.out.println("securityContext = " + securityContext);
                System.out.println("Child Thread : " + Thread.currentThread().getName());
                return securityContext.getAuthentication();
            }
        };
    }

    @GetMapping("/async")
    public Authentication async() {
        SecurityContext securityContext = SecurityContextHolder.getContextHolderStrategy().getContext();
        System.out.println("securityContext = " + securityContext);
        System.out.println("Parent Thread : " + Thread.currentThread().getName());

        asyncService.asyncMethod();

        return securityContext.getAuthentication();

    }
}