package com.isolutions4u.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isolutions4u.onlineshopping.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

}
