package com.project.salsaModasManager.service;

import com.project.salsaModasManager.model.Produto;
import com.project.salsaModasManager.repository.jpaRepositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;

@Service
public class ProductService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto insert(Produto produto){
        produto.setDataCriacao(LocalDate.now());
        DecimalFormat df = new DecimalFormat("0.##");
        produto.setPrecoCompra(Double.valueOf(df.format(produto.getPrecoCompra()).replace(",",".")));
        return produtoRepository.save(produto);
    }


}
