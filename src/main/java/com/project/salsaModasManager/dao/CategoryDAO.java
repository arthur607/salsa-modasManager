package com.project.salsaModasManager.dao;

import com.project.salsaModasManager.model.Subcategory;
import lombok.Builder;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
@Builder
@Data
public class CategoryDAO /*implements DefaultDAO<CategoryDAO>*/ {

    private Long id;
    private String name;
    private Subcategory subcategory;


//    @Override
//    public CategoryDAO mapper(ResultSet resultSet) throws SQLException {
//        return new CategoryDAOBuilder()
//                .id(resultSet.getLong(1))
//                .name(resultSet.getString(2))
//                .subcategory(resultSet.getObject(3,Subcategory.class))
//                .build();
//    }
}
