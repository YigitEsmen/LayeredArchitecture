package com.yigitesmen.layeredarchitecture.dataaccess.category;

import com.yigitesmen.layeredarchitecture.entities.Category;

import java.util.List;

public interface CategoryDAO {

    List<Category> fetchCategories();

    void addCategory(Category category);

    void deleteCategory(Category category);
}
