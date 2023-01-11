package com.springboot.applypage.data.repository;

import com.springboot.applypage.data.entity.BackendApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackendApplicationRepository
        extends JpaRepository<BackendApplication, String>{
}
