package com.pluralsight.springbootconferencedemo.repositories;

import com.pluralsight.springbootconferencedemo.models.Speaker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
