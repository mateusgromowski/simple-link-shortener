package com.github.mateusgromowski.simplelinkshortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.mateusgromowski.simplelinkshortener.model.Link;
import com.github.mateusgromowski.simplelinkshortener.service.LinkService;

@RestController
public class LinkController {
    private LinkService service;

    public LinkController(LinkService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Link> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Link> create(@RequestBody String url) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(url));
    }
}
