package com.isolutions4u.onlineshopping.repository;

import com.isolutions4u.onlineshopping.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);

}
