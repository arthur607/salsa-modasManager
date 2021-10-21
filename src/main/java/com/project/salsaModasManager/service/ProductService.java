package com.project.salsaModasManager.service;

import com.project.salsaModasManager.model.Produto;
import com.project.salsaModasManager.repository.jpaRepositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Produto insert(Produto produto){
        produto.setDataCriacao(LocalDate.now());
        DecimalFormat df = new DecimalFormat("0.##");
        produto.setPrecoCompra(Double.valueOf(df.format(produto.getPrecoCompra()).replace(",",".")));
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll(){
        final String sql = "select * from tbl_produto";

       return jdbcTemplate.query(sql, new RowMapper<Produto>() {
           @Override
           public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
               return Produto.builder()
                       .id(rs.getLong(1))
                       .cor(rs.getString(2))
                       .dataCriacao(rs.getObject(3,LocalDate.class))
                       .descricao(rs.getString(4))
                       .fornecedor(rs.getString(5))
                       .precoCompra(rs.getDouble(6))
                       .build();
           }
       });

    }




}
