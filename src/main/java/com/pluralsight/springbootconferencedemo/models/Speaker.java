package com.pluralsight.springbootconferencedemo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(name = "speakers")
public class Speaker implements Serializable {

  @Id
  @Column(name = "speaker_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name", nullable = false, precision = 30)
  private String firstName;

  @Column(name = "last_name", nullable = false, precision = 30)
  private String lastName;

  @Column(name = "title", nullable = false, precision = 40)
  private String title;

  @Column(name = "company", nullable = false, precision = 50)
  private String company;

  @Column(name = "speaker_bio", nullable = false, precision = 2000)
  private String bio;

  @Lob
  @Type(type = "org.hibernate.type.BinaryType")
  @Column(name = "speaker_photo")
  private byte[] photo;

  @ManyToMany(mappedBy = "speakers")
  private List<Session> sessions;
}
