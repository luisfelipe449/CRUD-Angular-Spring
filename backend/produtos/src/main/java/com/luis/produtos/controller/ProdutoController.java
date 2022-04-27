package com.luis.produtos.controller;

import com.luis.produtos.model.Produto;
import com.luis.produtos.repository.ProdutoRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/produto")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<Iterable<Produto>> listar() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable Integer id) {
        return ResponseEntity.ok(produtoRepository.findById(id).get());
    }

    @PostMapping
    public Produto save(@RequestBody Produto cliente) {
        return produtoRepository.save(cliente);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        produtoRepository.findById(id)
                .map(cliente -> {
                    produtoRepository.delete(cliente);
                    return cliente;
                });

    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id,
            @RequestBody Produto cliente) {
        produtoRepository
                .findById(id)
                .map(clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    produtoRepository.save(cliente);
                    return clienteExistente;
                });
    }

}
