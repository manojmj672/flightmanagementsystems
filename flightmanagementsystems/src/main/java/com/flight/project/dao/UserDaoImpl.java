package com.flight.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flight.project.dto.User;

public interface UserDaoImpl extends JpaRepository<User, Long>{
    }