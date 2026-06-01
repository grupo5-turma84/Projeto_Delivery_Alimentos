package com.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.model.Produto;
import com.delivery.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> recomendarProdutosSaudaveis() {

        return repository.findAll()
                .stream()
                .filter(produto -> produto.getCalorias() <= 300)
                .toList();
    }
}