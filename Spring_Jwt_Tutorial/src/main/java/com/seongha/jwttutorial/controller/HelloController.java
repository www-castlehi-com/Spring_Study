package com.seongha.jwttutorial.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String index() {
        return "APIExamNaverLogin";
    }

    @RequestMapping(value="/login/oauth2/code/naver", method=RequestMethod.GET)
    public String loginPOSTNaver(HttpSession session) {
        return "callback";
    }
}
