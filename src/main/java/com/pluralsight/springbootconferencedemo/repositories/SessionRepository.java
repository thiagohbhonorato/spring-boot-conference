package com.pluralsight.springbootconferencedemo.repositories;

import com.pluralsight.springbootconferencedemo.models.Session;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
