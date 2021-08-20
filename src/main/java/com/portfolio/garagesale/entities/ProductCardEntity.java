package com.portfolio.garagesale.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity @Table (name = "product_card")
public class ProductCardEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "product_card_id", unique = true)
    private Long id;

    @NonNull @Column(nullable = false)
    private String title;
    private String description;
    @NonNull @Column(nullable = false)
    private Long price;

    @ManyToOne @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userId;
}
