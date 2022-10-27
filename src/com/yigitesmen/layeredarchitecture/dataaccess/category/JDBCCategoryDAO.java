package com.yigitesmen.layeredarchitecture.dataaccess.category;

import com.yigitesmen.layeredarchitecture.entities.Category;

import java.util.ArrayList;
import java.util.List;

public class JDBCCategoryDAO implements CategoryDAO {

    @Override
    public List<Category> fetchCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Programlama"));
        return categories;
    }

    @Override
    public void addCategory(Category category) {
        // some JDBC codes here
        //
        //
        System.out.printf("Added category named \"%s\" using JDBC%n", category.getName());
    }

    @Override
    public void deleteCategory(Category category) {
        // some JDBC codes here
        //
        //
        System.out.printf("Deleted category named \"%s\" using JDBC%n", category.getName());
    }
}
