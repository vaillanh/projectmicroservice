package com.authProject.authProject.controller;

import com.authProject.authProject.entity.Authtoken;
import com.authProject.authProject.service.AuthtokenService;
import com.authProject.authProject.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthTokenController {

    private final JwtUtil jwtUtil;
    private final AuthtokenService authtokenService;

    public AuthTokenController(JwtUtil jwtUtil, AuthtokenService authtokenService) {
        this.jwtUtil = jwtUtil;
        this.authtokenService = authtokenService;
    }

    @PostMapping("/login")
    public String login(@RequestBody String name) {
        String token = jwtUtil.generateToken(name);
        Authtoken authtoken = new Authtoken();
        authtoken.setToken(token);
        authtokenService.addAuthtoken(authtoken);

        return "Bearer " + token;
    }
}
