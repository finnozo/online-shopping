package com.isolutions4u.onlineshopping.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.isolutions4u.onlineshopping.dao.CategoryDAO;
import com.isolutions4u.onlineshopping.model.Category;

@Repository("categoryDAO")
public class CategoryImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	static {
		Category category = new Category();

		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageUrl("cat_1.png");
		category.setActive(true);
		categories.add(category);

		// adding second category

		category = new Category();

		// adding first category
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some description for mobile");
		category.setImageUrl("cat_2.png");
		category.setActive(true);
		categories.add(category);

		category = new Category();

		// adding first category
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some description for laptop");
		category.setImageUrl("cat_2.png");
		category.setActive(true);
		categories.add(category);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub

		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}

		return null;
	}

}
