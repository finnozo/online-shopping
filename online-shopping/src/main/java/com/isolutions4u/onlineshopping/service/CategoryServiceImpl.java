package com.isolutions4u.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.isolutions4u.onlineshopping.model.Category;
import com.isolutions4u.onlineshopping.repository.CategoryRepository;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Qualifier("categoryRepository")
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public String saveCategory(Category category) {
		// TODO Auto-generated method stub

		categoryRepository.saveAndFlush(category);
		return "Save Sucessfully";
	}

	@Override
	public List<Category> findAllCategories() {
		// TODO Auto-generated method stub

		List<Category> categories = new ArrayList<>();
		categoryRepository.findAll().forEach(categories::add);
		for (Category c : categories) {
			if (!c.isActive()) {
				categories.remove(c);
			}
		}
		return categories;

	}

	@Override
	public Category findCategoryById(Integer id) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findOne(id);
		if (!category.isActive()) {
			category = null;
		}
		return category;
	}

	@Override
	public String deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		Category c = categoryRepository.findOne(id);
		c.setActive(false);
		categoryRepository.saveAndFlush(c);
		return "Deleted Successfully";
	}

	@Override
	public String updateCategory(Category category) {
		// TODO Auto-generated method stub
		categoryRepository.saveAndFlush(category);
		return "Updated Successfully";
	}

}
