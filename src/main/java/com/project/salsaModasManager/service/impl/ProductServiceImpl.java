package com.project.salsaModasManager.service.impl;

import com.project.salsaModasManager.model.Produto;
import com.project.salsaModasManager.repository.jpaRepositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {

    @Autowired
    ProdutoRepository produtoRepository;


   /* @Autowired
    private JdbcTemplate jdbcTemplate;*/

    @Transactional
    public Produto insert(Produto produto) {
        produto.setDataCriacao(LocalDate.now());
        DecimalFormat df = new DecimalFormat("0.##");
        produto.setPrecoCompra(BigDecimal.valueOf(Double.parseDouble(df.format(produto.getPrecoCompra()).replace(",", "."))));
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return Optional.of(produtoRepository.findAll())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

}
