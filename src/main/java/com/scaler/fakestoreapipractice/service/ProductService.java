package com.scaler.fakestoreapipractice.service;

import com.scaler.fakestoreapipractice.exception.ProductNotFound;
import com.scaler.fakestoreapipractice.models.Product;

public interface ProductService {
    public Product getProduct(int id) throws ProductNotFound;
    public Product[] getAllProducts();
    public Product createProduct(Product p);
    public Product updateProduct(int id, Product p);
    public Product partialUpdateProduct(int id,Product p);
    public String deleteProduct(int id);
}
