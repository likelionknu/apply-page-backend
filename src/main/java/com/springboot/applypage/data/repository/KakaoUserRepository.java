package com.springboot.applypage.data.repository;

import com.springboot.applypage.data.entity.User;
import com.springboot.applypage.data.entity.kakaoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KakaoUserRepository extends JpaRepository<kakaoUser, Long> {

    Optional<kakaoUser> findByKakaoEmail(String email);

}
