package com.example.crud5.Services;

import com.example.crud5.Model.Product;
import com.example.crud5.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {

    @Autowired
    ProductRepo productRepo;

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product>  getAllProducts(){
        return productRepo.findAll();
    }
    public Product getProductById(Long id){
        return productRepo.findById(id).get();
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = getProductById(id);
        if (existingProduct != null) {
            if (updatedProduct.getProductName() != null) {
                existingProduct.setProductName(updatedProduct.getProductName());
            }
            if (updatedProduct.getPrice() != null) {
                existingProduct.setPrice(updatedProduct.getPrice());
            }
            if (updatedProduct.getQuantity() != null) {
                existingProduct.setQuantity(updatedProduct.getQuantity());
            }

            return productRepo.save(existingProduct);
        }
        return null;
    }
    public void deleteById(Long id){
        productRepo.deleteById(id);
    }



}
