package com.project.salsaModasManager.dao;

import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Subcategory;
import com.project.salsaModasManager.repository.CrudRepository;
import com.project.salsaModasManager.repository.jpaRepositories.CategoryRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Builder
//@Data
//public class CategoryDAO{


    //    @Override
//    public CategoryDAO mapper(ResultSet resultSet) throws SQLException {
//        return new CategoryDAOBuilder()
//                .id(resultSet.getLong(1))
//                .name(resultSet.getString(2))
//                .subcategory(resultSet.getObject(3,Subcategory.class))
//                .build();
//    }
//}
