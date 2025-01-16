package com.authProject.authProject.repository;

import com.authProject.authProject.entity.Authtoken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthtokenRepository extends JpaRepository<Authtoken, Long> {
    Authtoken findByToken(String token);

}
