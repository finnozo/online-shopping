package com.isolutions4u.onlineshopping.dao;

import java.util.List;

import com.isolutions4u.onlineshopping.model.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);

}
