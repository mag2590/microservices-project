package com.programmingtechie.productservice.service;


import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.dto.ProductResponse;
import com.programmingtechie.productservice.model.Product;
import com.programmingtechie.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(new BigDecimal(productRequest.getPrice()))
                .build();
        productRepository.save(product);
        log.info("Product created and saved: {}", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToProductResponse)
                .toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
            return ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice().toString())
                    .build();
    }
}
