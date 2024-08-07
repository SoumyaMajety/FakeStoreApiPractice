package com.scaler.fakestoreapipractice.service;

import com.scaler.fakestoreapipractice.dtos.FakeStoreProductRequestDto;
import com.scaler.fakestoreapipractice.dtos.FakeStoreProductResponseDto;
import com.scaler.fakestoreapipractice.exception.ProductNotFound;
import com.scaler.fakestoreapipractice.models.Category;
import com.scaler.fakestoreapipractice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){

        this.restTemplate=restTemplate;
    }
    @Override
    public Product getProduct(int id) throws ProductNotFound {
        FakeStoreProductResponseDto responseDto = this.restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,FakeStoreProductResponseDto.class);
        if(responseDto==null){
            throw new ProductNotFound();
        }
        return convertFakeStoreResponseToProduct(responseDto);
    }

    public Product convertFakeStoreResponseToProduct(FakeStoreProductResponseDto responseDto){
        Product p = new Product();
        p.setId(responseDto.getId());
        p.setDescription(responseDto.getDescription());
        p.setTitle(responseDto.getTitle());
        p.setPrice(responseDto.getPrice());
        p.setImage(responseDto.getImage());
        Category c = new Category();
        c.setTitle(responseDto.getCategory());
        p.setCategory(c);
        return p;
    }

    @Override
    public Product[] getAllProducts() {
        FakeStoreProductResponseDto[] responseDtos = this.restTemplate.getForObject(
          "https://fakestoreapi.com/products",FakeStoreProductResponseDto[].class);
        Product[] products = new Product[responseDtos.length];

/* Product[] products = new Product[responseDto.length];
        for (int i = 0; i < responseDto.length; i++) {
            Product p = convertFakeStoreResponseToProduct(responseDto[i]);
            products[i] = p;
            }
            return products;
        */

        // using streams

        Product[] products1 = Arrays.stream(responseDtos)
                .map(x->convertFakeStoreResponseToProduct(x))
                .toArray(size->new Product[size]);

        return products1;
    }

    @Override
    public Product createProduct(Product p) {
        FakeStoreProductRequestDto requestDto=convertProductToFakeStoreRequest(p);
        FakeStoreProductResponseDto responseDto= this.restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                requestDto,FakeStoreProductResponseDto.class);
        return convertFakeStoreResponseToProduct(responseDto);
    }

    public FakeStoreProductRequestDto convertProductToFakeStoreRequest(Product product){
        FakeStoreProductRequestDto requestDto= new FakeStoreProductRequestDto();
        requestDto.setTitle(product.getTitle());
        requestDto.setCategory(product.getCategory().getTitle());
        requestDto.setPrice(product.getPrice());
        requestDto.setImage(product.getImage());
        requestDto.setDescription(product.getDescription());
        return requestDto;
    }

    @Override
    public Product updateProduct(int id, Product p) {
        FakeStoreProductRequestDto requestDto= convertProductToFakeStoreRequest(p);
        this.restTemplate.put("https://fakestoreapi.com/products/"+id,requestDto);
        return p;
    }

    @Override
    public Product partialUpdateProduct(int id, Product p) {
        FakeStoreProductRequestDto requestDto= convertProductToFakeStoreRequest(p);
       FakeStoreProductResponseDto responseDto= this.restTemplate.patchForObject("https://fakestoreapi.com/products/"+id,requestDto,
                FakeStoreProductResponseDto.class);
        return convertFakeStoreResponseToProduct(responseDto);
    }

    @Override
    public String deleteProduct(int id) {
        this.restTemplate.delete("https://fakestoreapi.com/products/"+id);
        return "Product deleted";
    }
}
