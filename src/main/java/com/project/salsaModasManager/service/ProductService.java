package com.project.salsaModasManager.service;

import com.project.salsaModasManager.dto.ProductDto;
import com.project.salsaModasManager.model.Produto;
import com.project.salsaModasManager.repository.jpaRepositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProdutoRepository produtoRepository;


   /* @Autowired
    private JdbcTemplate jdbcTemplate;*/

    @Transactional
    public Produto insert(Produto produto){
        produto.setDataCriacao(LocalDate.now());
        DecimalFormat df = new DecimalFormat("0.##");
        produto.setPrecoCompra(Double.valueOf(df.format(produto.getPrecoCompra()).replace(",",".")));
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }



}
