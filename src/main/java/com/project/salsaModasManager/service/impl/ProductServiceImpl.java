package com.project.salsaModasManager.service.impl;

import com.project.salsaModasManager.Exception.NotFoundException;
import com.project.salsaModasManager.model.Category;
import com.project.salsaModasManager.model.Produto;
import com.project.salsaModasManager.model.dto.Request.ProductRequest;
import com.project.salsaModasManager.model.dto.Response.ProductResponse;
import com.project.salsaModasManager.model.mapper.ProductMapper;
import com.project.salsaModasManager.repository.jpaRepositories.ProdutoRepository;
import com.project.salsaModasManager.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProdutoRepository produtoRepository;

    ProductMapper productMapper;


    @Transactional
    public Produto insert(Produto produto) {
        produto.setDataCriacao(LocalDate.now());
        DecimalFormat df = new DecimalFormat("0.##");
        produto.setPrecoCompra(BigDecimal.valueOf
                (Double.parseDouble(df.format
                        (produto.getPrecoCompra()).replace(",", "."))));
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> findByName(String nome) {
        return null;
    }

    public List<Produto> findAll() {
        return Optional.of(produtoRepository.findAll())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public ProductResponse getById(Long productId) {
        Produto produto = produtoRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(("Id não encotrado !")));
        return productMapper.toDTO(produto);
    }

    @Override
    public ProductResponse create(ProductRequest productRequest) throws Exception {
        Produto produto = productMapper.toModel(productRequest);
        produto.setCategory(Category.builder().id(productRequest.getIdCategory()).build());
        produto.setDataCriacao(LocalDate.now());
        DecimalFormat df = new DecimalFormat("0.##");
        produto.setPrecoCompra(BigDecimal.valueOf
                (Long.parseLong(df.format
                        (productRequest.getPrecoCompra()).replace(",", "."))));
        return productMapper.toDTO(produtoRepository.save(produto));
    }

    @Override
    public ProductResponse update(Long id, ProductRequest productRequest) {
        produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(("Id não encotrado !")));
        return productMapper.toDTO(
                produtoRepository.save(
                        Produto.builder()
                                .id(id)
                                .descricao(productRequest.getDescricao())
                                .precoCompra(productRequest.getPrecoCompra())
                                .cor(productRequest.getCor())
                                .fornecedor(productRequest.getFornecedor())
                                .category(Category.builder()
                                        .id(productRequest.getIdCategory())
                                        .build())
                                .build()
                )
        );

    }

    @Override
    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }
}
