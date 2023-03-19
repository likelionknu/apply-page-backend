package com.springboot.applypage.data.repository;

import com.springboot.applypage.data.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users getByUid(String uid);

}
