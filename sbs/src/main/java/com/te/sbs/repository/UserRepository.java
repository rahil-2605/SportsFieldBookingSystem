package com.te.sbs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.sbs.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByEmail(String email);

}
