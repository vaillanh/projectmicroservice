package com.authProject.authProject.service;

import com.authProject.authProject.entity.Authtoken;
import com.authProject.authProject.repository.AuthtokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthtokenService {

    @Autowired
    private AuthtokenRepository authtokenRepository;

    public Authtoken getTokenById(String token){return authtokenRepository.findByToken(token) ;}
    public void addAuthtoken(Authtoken authtoken){authtokenRepository.save(authtoken);}
}
