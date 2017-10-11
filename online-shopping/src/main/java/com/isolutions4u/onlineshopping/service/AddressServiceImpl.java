package com.isolutions4u.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.isolutions4u.onlineshopping.model.Address;
import com.isolutions4u.onlineshopping.repository.AddressRepository;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Qualifier("addressRepository")
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public boolean saveAddress(Address address) {
		// TODO Auto-generated method stub
		addressRepository.saveAndFlush(address);
		return true;
	}

}
