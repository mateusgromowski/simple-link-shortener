package com.github.mateusgromowski.simplelinkshortener.service;

import java.util.NoSuchElementException;

import com.github.mateusgromowski.simplelinkshortener.model.Link;
import com.github.mateusgromowski.simplelinkshortener.repository.LinkRepository;

public class LinkService {
    private LinkRepository repository;

    public LinkService(LinkRepository repository) {
        this.repository = repository;
    }

    public Link findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("There's no link of " + id + " id."));
    }

    public Link create(String url) {
        if (repository.existsByUrl(url)) {
            return repository.findByUrl(url);
        }
        Link link = new Link(url);
        return repository.save(link);
    }

}
