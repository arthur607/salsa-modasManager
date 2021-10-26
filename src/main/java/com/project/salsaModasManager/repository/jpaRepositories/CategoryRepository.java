package com.project.salsaModasManager.repository.jpaRepositories;

import com.project.salsaModasManager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    List<Category> findByNomeContaining(String nome);


}
