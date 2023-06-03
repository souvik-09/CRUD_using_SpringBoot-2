package com.example.crud5.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long productId;
    String productName;
    Double price;
    Integer quantity;

}
