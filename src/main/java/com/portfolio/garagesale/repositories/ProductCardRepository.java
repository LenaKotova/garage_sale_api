package com.portfolio.garagesale.repositories;

import com.portfolio.garagesale.entities.ProductCardEntity;
import com.portfolio.garagesale.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCardRepository  extends CrudRepository<ProductCardEntity, Long> {
    List<ProductCardEntity> findByTitleContainsIgnoreCase (String title);
    ProductCardEntity findByDescription (String description);
    List <ProductCardEntity> findByUserId (UserEntity userId);
}
