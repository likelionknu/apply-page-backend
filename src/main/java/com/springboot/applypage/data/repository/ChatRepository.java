package com.springboot.applypage.data.repository;

import com.springboot.applypage.data.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository
        extends JpaRepository<Chat, Long> {
}
