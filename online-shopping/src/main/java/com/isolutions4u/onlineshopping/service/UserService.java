package com.isolutions4u.onlineshopping.service;

import com.isolutions4u.onlineshopping.model.User;

public interface UserService {

    boolean saveUser(User user);

    User findUserByEmail(String email);

}
