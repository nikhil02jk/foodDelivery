package com.learning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	Boolean existsByEmail(String email);
	Optional<Login> findByEmail(String email);
	void deleteByEmail(String email);
}