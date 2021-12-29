package com.project.salsa_Modas_Manager.repository.jpaRepositories;

import com.project.salsa_Modas_Manager.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    @Query(value = "select * from tbl_category;",nativeQuery = true)
    LinkedList<Category> findAllCategory();

    @Query(value = "select * from tbl_category where nome = ?", nativeQuery = true)
    LinkedList<Category> findByNomeContaining(String nome);

    @Query(value = "select nome from tbl_category;", nativeQuery = true)
    List<String> categoryNames();

}
