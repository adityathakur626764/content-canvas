package com.martian.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martian.blog.entities.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
