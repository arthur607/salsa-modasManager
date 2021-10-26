package com.project.salsaModasManager.repository.jpaRepositories;

import com.project.salsaModasManager.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}