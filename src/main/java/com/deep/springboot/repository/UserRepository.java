package com.deep.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deep.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User>findByEmailAndPassword(String email, String password);
}
