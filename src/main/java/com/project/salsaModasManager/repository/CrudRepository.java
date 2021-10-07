package com.project.salsaModasManager.repository;

import com.project.salsaModasManager.model.Category;
import java.util.List;


public interface CrudRepository<T> {

    public List<T> findAll();

    public T insert(Category category);

    public void delete(Category category);

    public T update();




}
