package com.soa.tourism.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.soa.tourism.model.LoginForm;
import com.soa.tourism.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.email = :email and u.password = :password")
	public Optional<User> getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
