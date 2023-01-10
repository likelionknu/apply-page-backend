package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.ProductDto;
import com.springboot.applypage.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDto);
    ProductResponseDto changeProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;

}
