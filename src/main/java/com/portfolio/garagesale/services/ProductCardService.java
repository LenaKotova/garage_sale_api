package com.portfolio.garagesale.services;

import com.portfolio.garagesale.entities.ProductCardEntity;
import com.portfolio.garagesale.entities.UserEntity;
import com.portfolio.garagesale.exceptions.ProductCardNotFoundsException;
import com.portfolio.garagesale.models.ProductCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.garagesale.repositories.ProductCardRepository;
import com.portfolio.garagesale.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCardService {
    @Autowired
    private ProductCardRepository productRepo;
    @Autowired
    private UserRepository userRepo;

    public ProductCard createProductCard(ProductCardEntity productCard, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        productCard.setUserId(user);
        return ProductCard.toModel(productRepo.save(productCard));
    }


    public ProductCard changeProductCart (ProductCard changedProductCard, Long id){
        ProductCardEntity productCard = productRepo.findById(id).get();
        productCard.setTitle(changedProductCard.getTitle());
        productCard.setDescription(changedProductCard.getDescription());
        productCard.setPrice(changedProductCard.getPrice());
        return ProductCard.toModel(productRepo.save(productCard));
    }

    public ProductCard getOneCard(Long id) throws ProductCardNotFoundsException {
       Optional<ProductCardEntity> productCard = productRepo.findById(id);
        if (!productCard.isPresent() || productCard.get() ==null) {
            throw new ProductCardNotFoundsException(id);
        }
        return ProductCard.toModel(productCard.get());
    }

    public List<ProductCard> getCardsByTitle (String title){
        List<ProductCardEntity> entities = productRepo.findByTitleContainsIgnoreCase(title);
        List<ProductCard> productCards = new ArrayList<>();
        for (ProductCardEntity i: entities) {
            productCards.add(ProductCard.toModel(i));
        }
        return productCards;
    }

    public List<ProductCard> getCardsByUser (UserEntity id){
        List<ProductCardEntity> entities = productRepo.findByUserId(id);
        List<ProductCard> productCards = new ArrayList<>();
        for (ProductCardEntity i: entities) {
            productCards.add(ProductCard.toModel(i));
        }
        return productCards;
    }


    public Long deleteProductCard(Long id){
        productRepo.deleteById(id);
        return id;
    }
}
