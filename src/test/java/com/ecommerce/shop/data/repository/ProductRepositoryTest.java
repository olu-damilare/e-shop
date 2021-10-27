package com.ecommerce.shop.data.repository;

import com.ecommerce.shop.data.dto.ProductUpdateDto;
import com.ecommerce.shop.data.model.Currency;
import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
@Sql(scripts ={"/db/insert.sql"})
@Transactional
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepositoryImpl;

    @Autowired
    ProductService productService;


    @BeforeEach
    void setUp() {

    }
    @Test
        public void createProductTest(){
            Product product = new Product();
            product.setName("Luxury Sofa");
            product.setPrice(400D);
            product.setCurrency(Currency.NGN);
            product.setDetails("Soap for bath");
            assertThat(product).isNotNull();
            assertThat(product.getId()).isNull();
            log.info("Product before saving -> {}", product );
            productRepositoryImpl.save(product);
            assertThat(product.getId()).isNotNull();
            log.info("Product after saving -> {}", product);
        }

        @Test
        public void whenFindAllProductISCalledThenProductListIsReturnedTest(){
        List<Product> products = productRepositoryImpl.findAll();
        assertThat(products).hasSize(4);
        log.info("Product returned from database -> {}", products);
        }

        @Test
        public void findExistingProductById(){
        Product existingProduct =
        productRepositoryImpl.findById(110L).orElse(null);
        assertThat(existingProduct).isNotNull();
        log.info("Product -> {}",existingProduct);
        }

        @Test
        public void deleteExistingProductById(){
        assertThat(productRepositoryImpl.findById(110L).orElse(null)).isNotNull();
        productRepositoryImpl.deleteById(110L);
        assertThat(productRepositoryImpl.findById(110L).orElse(null)).isNull();

        }

        @Test
        void testToUpdateProduct(){
        Product product = productRepositoryImpl.findById(110L).orElse(null);
        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualTo("luxury chair");

        ProductUpdateDto productDto = new ProductUpdateDto();
        productDto.setName("A fancy couch");
        product = productService.updateProduct(110L, productDto);
        assertThat(product.getName()).isEqualTo(productDto.getName());
        }
}