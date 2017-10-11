package com.isolutions4u.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.isolutions4u.onlineshopping.model.User;
import com.isolutions4u.onlineshopping.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Qualifier("userRepository")
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.saveAndFlush(user);
		return true;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findUserByEmail(email);
	}

}
