package com.springboot.applypage.data.repository;

import com.springboot.applypage.data.entity.FrontendApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrontendApplicationRepository
        extends JpaRepository<FrontendApplication, String> {
}
