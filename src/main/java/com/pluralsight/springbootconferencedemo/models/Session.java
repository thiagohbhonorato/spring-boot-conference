package com.pluralsight.springbootconferencedemo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(name = "sessions")
public class Session implements Serializable {

  @Id
  @Column(name = "session_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "session_name", nullable = false, precision = 80)
  private String name;

  @Column(name = "session_description", nullable = false, precision = 1024)
  private String description;

  @Column(name = "session_length", nullable = false)
  private Integer length;

  @ManyToMany
  @JoinTable(name = "session_speakers", joinColumns = @JoinColumn(referencedColumnName = "session_id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "speaker_id"))
  private List<Speaker> speakers;
}
