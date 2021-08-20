package com.portfolio.garagesale.models;

import com.portfolio.garagesale.entities.UserEntity;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
public class User {
    private Long id;
    private String login;
    private String name;
    //private List<ProductCard> productCards;

    public static User toModel(UserEntity userEntity){
        User model = new User();
        model.setId(userEntity.getId());
        model.setLogin(userEntity.getLogin());
        model.setName(userEntity.getName());
        /*model.setProductCards(userEntity.getProductCards().stream()
                .map(ProductCard::toModel).collect(Collectors.toList()));*/
        return model;
    }
}
