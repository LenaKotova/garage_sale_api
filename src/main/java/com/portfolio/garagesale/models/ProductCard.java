package com.portfolio.garagesale.models;

import com.portfolio.garagesale.entities.ProductCardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductCard {
    private Long id;
    private String title;
    private String description;
    private Long price;

    public static ProductCard toModel (ProductCardEntity cardEntity){
        ProductCard model = new ProductCard();
        model.setId(cardEntity.getId());
        model.setTitle(cardEntity.getTitle());
        model.setDescription(cardEntity.getDescription());
        model.setPrice(cardEntity.getPrice());
        return model;
    }
}
