package com.flight.project.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.project.dto.Schedule;

public interface ScheduleDaoImpl extends JpaRepository<Schedule, BigInteger>{



}