package com.project.salsa_Modas_Manager.service.impl;

import com.project.salsa_Modas_Manager.Exception.NotFoundException;
import com.project.salsa_Modas_Manager.model.Category;
import com.project.salsa_Modas_Manager.model.Produto;
import com.project.salsa_Modas_Manager.model.dto.Request.ProductRequest;
import com.project.salsa_Modas_Manager.model.dto.Response.ProductResponse;
import com.project.salsa_Modas_Manager.repository.jpaRepositories.ProdutoRepository;
import com.project.salsa_Modas_Manager.service.ProductService;
import com.project.salsa_Modas_Manager.utils.ProductConverter;
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

    @Autowired
    ProductConverter productConverter;


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
                .orElseThrow(() -> new NotFoundException(("Id não encontrado !")));
        return productConverter.toDTO(produto);
    }

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        Produto produto = productConverter.toModel(productRequest);
        produto.setCategory(Category.builder().id(productRequest.getIdCategory()).build());
        produto.setDataCriacao(LocalDate.now());
        return productConverter.toDTO(produtoRepository.save(produto));
    }

    @Override
    public ProductResponse update(Long id, ProductRequest productRequest) {
        produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(("Id não encontrado !")));
        return productConverter.toDTO(
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
