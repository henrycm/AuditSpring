package com.auditing.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditing.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
