package com.example.crud5.Controller;

import com.example.crud5.Model.Product;
import com.example.crud5.Services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @GetMapping("getAllProducts")
    public List<Product>getAllProducts(){
        return productServiceImpl.getAllProducts();
    }

    @GetMapping("getProduct/{id}")
    public Product getProductById(@PathVariable Long id){
        return productServiceImpl.getProductById(id);

    }

    @PostMapping("addProduct")
    public Product addProduct(@RequestBody Product product){
        return productServiceImpl.addProduct(product);
    }

    @PatchMapping("updateProduct/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productServiceImpl.updateProduct(id, updatedProduct);
    }
    @DeleteMapping("deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id){
        productServiceImpl.deleteById(id);
        return "Product is deleted!";
    }


}
