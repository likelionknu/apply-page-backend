package com.springboot.applypage.data.repository;

import com.springboot.applypage.data.entity.DesignApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignApplicationRepository
        extends JpaRepository<DesignApplication, String> {
}
