package com.springboot.applypage.data.repository;

import com.springboot.applypage.data.entity.ChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeHistoryRepository
        extends JpaRepository<ChangeHistory, Long> {
}
