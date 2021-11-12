package com.project.salsa_Modas_Manager.repository.jpaRepositories;

import com.project.salsa_Modas_Manager.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}