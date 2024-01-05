package com.martian.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martian.blog.entities.Comment;

public interface CommentRepo  extends JpaRepository<Comment	, Integer> {

}
