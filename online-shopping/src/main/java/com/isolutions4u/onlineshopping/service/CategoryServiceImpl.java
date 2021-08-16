package com.isolutions4u.onlineshopping.service;

import com.isolutions4u.onlineshopping.model.Category;
import com.isolutions4u.onlineshopping.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Qualifier("categoryRepository")
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public String saveCategory(Category category) {
        // TODO Auto-generated method stub
        category.setActive(true);
        categoryRepository.saveAndFlush(category);
        return "Save Sucessfully";
    }

    @Override
    public List<Category> findAllCategories() {
        // TODO Auto-generated method stub

        List<Category> categories = new ArrayList<>();
        List<Category> categoriesCopy = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        categoriesCopy.addAll(categories);
        for (Category c : categories) {
            System.out.println(c);
            if (!c.isActive()) {
                categoriesCopy.remove(c);
            }
        }
        return categoriesCopy;

    }

    @Override
    public Category findCategoryById(Integer id) {
        // TODO Auto-generated method stub
        Category category = categoryRepository.getOne(id);
        if (!category.isActive()) {
            category = null;
        }
        return category;
    }

    @Override
    public String deleteCategory(Integer id) {
        // TODO Auto-generated method stub
        Category c = categoryRepository.getOne(id);
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
