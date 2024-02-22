package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.Product;
import com.example.demo.persistence.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductController {

    private ProductRepository repository;
    
    public ProductController(@Autowired ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/products")
    public List<Product> allProduct() {
        return (List<Product>) repository.findAll();
    }

}
