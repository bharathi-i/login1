package com.example.demo.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	 Users findByname(String name);
}
