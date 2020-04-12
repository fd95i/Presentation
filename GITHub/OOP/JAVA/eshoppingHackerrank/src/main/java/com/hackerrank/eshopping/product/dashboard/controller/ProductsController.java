package com.hackerrank.eshopping.product.dashboard.controller;

import java.sql.SQLException;
import java.util.List;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.stock.ProductStockDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsController {
    
    @Autowired
    private ProductStockDao productStockDao;

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product p) throws SQLException, ClassNotFoundException {
          if(!productStockDao.productExists(p.getId())) {
            productStockDao.addProduct(p);
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    //@formatter:off
    @PutMapping("products/{id}")
    public ResponseEntity<Product> updateProduct (
            @PathVariable("id") Long id,
            @RequestBody Product product) throws SQLException, ClassNotFoundException {
        if(productStockDao.productExists(id)) {
            productStockDao.updateProduct(id, product);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/products/{id}")
    public @ResponseBody ResponseEntity<Product> getProductById(
            @PathVariable("id") Long id) throws SQLException, ClassNotFoundException {
        return productStockDao.getProductById(id);
    }

    @GetMapping("/products")
    public @ResponseBody ResponseEntity<List<Product>> getProductsByCategory(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "availability", required = false) Boolean availability) throws SQLException, ClassNotFoundException {
        return productStockDao.getProducts(category, availability);
    }
    //@formatter:on
}
