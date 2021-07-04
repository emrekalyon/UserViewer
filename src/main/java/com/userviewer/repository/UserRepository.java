package com.userviewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userviewer.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
