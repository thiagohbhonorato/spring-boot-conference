package com.pluralsight.springbootconferencedemo.controllers;

import java.util.List;

import com.pluralsight.springbootconferencedemo.models.Speaker;
import com.pluralsight.springbootconferencedemo.repositories.SpeakerRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

  @Autowired
  private SpeakerRepository speakerRepository;

  @GetMapping
  public List<Speaker> list() {
    return speakerRepository.findAll();
  }

  @GetMapping
  @RequestMapping("{id}")
  public Speaker get(@PathVariable Long id) {
    return speakerRepository.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Speaker create(@RequestBody final Speaker speaker) {
    return speakerRepository.saveAndFlush(speaker);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    speakerRepository.deleteById(id);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
    Speaker existingSpeaker = speakerRepository.getById(id);
    BeanUtils.copyProperties(speaker, existingSpeaker, "id");
    return speakerRepository.saveAndFlush(existingSpeaker);
  }
}
