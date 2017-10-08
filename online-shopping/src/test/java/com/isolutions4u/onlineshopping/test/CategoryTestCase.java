package com.isolutions4u.onlineshopping.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import com.isolutions4u.onlineshopping.dao.CategoryDAO;
import com.isolutions4u.onlineshopping.model.Category;

public class CategoryTestCase {

	/*private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;
	private static Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.isolutions4u.onlineshopping");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void testAddCategory() {
		category = new Category();

		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageUrl("cat_1.png");
		category.setActive(true);

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
	}*/

}
