package com.project.salsaModasManager.dao;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Subcategory;
import com.project.salsaModasManager.repository.CategoryRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Builder
@Data
public class CategoryDAO /*implements DefaultDAO<CategoryDAO>*/ {

    private Long id;
    private String name;
    private Subcategory subcategory;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> list() {
        return categoryRepository.findAll();
    }

    //    @Override
//    public CategoryDAO mapper(ResultSet resultSet) throws SQLException {
//        return new CategoryDAOBuilder()
//                .id(resultSet.getLong(1))
//                .name(resultSet.getString(2))
//                .subcategory(resultSet.getObject(3,Subcategory.class))
//                .build();
//    }
}
