package com.ecommerce.shop.data.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Price cannot be null")
    private Double price;


    @Enumerated(EnumType.STRING)
    @NotNull(message = "Currency cannot be null")
    private Currency currency;
    @NotBlank(message = "Details cannot be blank")
    @NotNull(message = "Details cannot be null")
    private String details;

    @ElementCollection()
    @ToString.Exclude
    private List<String> imageUrl;

    @OneToMany
    @ToString.Exclude
    private List<Feedback> feedbacks;
}
