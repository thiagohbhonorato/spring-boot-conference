package com.pluralsight.springbootconferencedemo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

  @Value("${api.version}")
  private String apiVersion;

  @GetMapping
  public Map<String, String> api() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("api-version", apiVersion);
    return map;
  }
}
