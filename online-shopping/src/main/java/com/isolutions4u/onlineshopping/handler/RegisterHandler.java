package com.isolutions4u.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.isolutions4u.onlineshopping.model.Address;
import com.isolutions4u.onlineshopping.model.Cart;
import com.isolutions4u.onlineshopping.model.RegisterModel;
import com.isolutions4u.onlineshopping.model.User;
import com.isolutions4u.onlineshopping.service.AddressService;
import com.isolutions4u.onlineshopping.service.UserService;

@Component
public class RegisterHandler {

	@Qualifier("userService")
	@Autowired
	private UserService userService;

	@Qualifier("addressService")
	@Autowired
	private AddressService addressService;

	public RegisterModel init() {

		return new RegisterModel();

	}

	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}

	public String saveAll(RegisterModel registerModel) {
		String transitionValue = "success";

		// Getting User

		User user = registerModel.getUser();
		if (user.getRole().equalsIgnoreCase("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		// save User
		userService.saveUser(user);

		// Getting Address

		Address billing = registerModel.getBilling();

		billing.setUser(user);
		billing.setBilling(true);
		addressService.saveAddress(billing);

		return transitionValue;
	}

}
