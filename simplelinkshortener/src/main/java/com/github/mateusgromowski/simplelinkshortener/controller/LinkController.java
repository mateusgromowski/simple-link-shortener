package com.github.mateusgromowski.simplelinkshortener.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.mateusgromowski.simplelinkshortener.model.Link;
import com.github.mateusgromowski.simplelinkshortener.service.LinkService;

import jakarta.validation.Valid;

@RestController
public class LinkController {
    private LinkService service;

    public LinkController(LinkService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirect(@PathVariable Long id) {
        Link link = service.findById(id);
        System.out.println(link.getUrl());
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(link.getUrl())).build();
    }

    @PostMapping
    public ResponseEntity<Link> create(@RequestBody @Valid Link link) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(link));
    }
}
