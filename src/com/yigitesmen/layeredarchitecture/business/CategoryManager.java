package com.yigitesmen.layeredarchitecture.business;

import com.yigitesmen.layeredarchitecture.core.logging.Logger;
import com.yigitesmen.layeredarchitecture.dataaccess.category.CategoryDAO;
import com.yigitesmen.layeredarchitecture.entities.Category;

import java.util.List;

public class CategoryManager {
    private final CategoryDAO categoryDAO;
    private final List<Logger> loggers;
    private final List<Category> categories;

    public CategoryManager(CategoryDAO categoryDAO, List<Logger> loggers) {
        this.categoryDAO = categoryDAO;
        this.loggers = loggers;
        categories = categoryDAO.fetchCategories();
    }

    public void addCategory(Category category) throws Exception {
        if (isCategoryExists(category))
            throw new Exception(String.format("Failed to add category: \"%s\" is already exists%n", category.getName()));

        categoryDAO.addCategory(category);
        categories.add(category);
        for (Logger logger : loggers) {
            logger.log(String.format("Added category: %s", category.getName()));
        }
    }

    private boolean isCategoryExists(Category category) {
        return categories.stream().anyMatch(c -> c.getName().equalsIgnoreCase(category.getName()));
    }

    public void deleteCategory(Category category) {
        categoryDAO.deleteCategory(category);
        categories.remove(category);
        for (Logger logger : loggers) {
            logger.log(String.format("Deleted category: %s", category.getName()));
        }
    }

    public List<Category> getCategories() {
        return categories;
    }

    public int getCategoryCount() {
        return categories.size();
    }
}
