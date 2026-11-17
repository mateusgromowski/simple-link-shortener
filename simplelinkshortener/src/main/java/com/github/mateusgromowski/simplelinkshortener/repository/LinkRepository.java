package com.github.mateusgromowski.simplelinkshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.mateusgromowski.simplelinkshortener.model.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {
    boolean existsByUrl();
}
