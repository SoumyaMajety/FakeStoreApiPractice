package com.scaler.fakestoreapipractice.controllers;

import com.scaler.fakestoreapipractice.exception.ProductNotFound;
import com.scaler.fakestoreapipractice.models.Product;
import com.scaler.fakestoreapipractice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) throws ProductNotFound {
        // writing try catch for exception

        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
//        try {
//            return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
//        }
//        catch (ProductNotFound e){
//            return new ResponseEntity<>( null,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>( null,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    @GetMapping("/")
    public Product[] getAllProducts() {

        return productService.getAllProducts();
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product p = productService.createProduct(product);
        if (p == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(p);
//        return p;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PatchMapping("/{id}")
    public Product PartialUpdateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        return productService.partialUpdateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        return productService.deleteProduct(id);
    }

}
