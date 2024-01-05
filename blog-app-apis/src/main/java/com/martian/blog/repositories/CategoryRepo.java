package com.martian.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martian.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
