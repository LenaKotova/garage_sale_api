package com.portfolio.garagesale.controllers;

import com.portfolio.garagesale.entities.ProductCardEntity;
import com.portfolio.garagesale.entities.UserEntity;
import com.portfolio.garagesale.exceptions.ProductCardNotFoundsException;
import com.portfolio.garagesale.models.ProductCard;
import com.portfolio.garagesale.services.ProductCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api( description = "CRUD API operations with product cards", tags = "Products")
@RestController @RequestMapping("/api/products")
public class ProductCardController {
    @Autowired
    private ProductCardService productService;

    @ApiOperation(value = "Create product card", notes = "Create new product card")
    @PostMapping
    public ResponseEntity createProductCard(@RequestBody ProductCardEntity product,
                                            @RequestParam Long userId){
        try {
            return ResponseEntity.ok(productService.createProductCard(product, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @ApiOperation(value = "Change product card", notes = "Change product card parameters: title, description, price")
    @PutMapping
    public ResponseEntity changeProductCard (@RequestBody ProductCard card,
                                             @RequestParam Long id){
        try {
            return ResponseEntity.ok(productService.changeProductCart(card, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @ApiOperation(value = "Get product card", notes = "Get the product card")
    @GetMapping("/{id}")
    public ResponseEntity getOneProductCard (@PathVariable Long id){
        try {
            return ResponseEntity.ok(productService.getOneCard(id));
        } catch (ProductCardNotFoundsException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Find product cards by title", notes = "Find all product cards with the title")
    @GetMapping("/title")
    public ResponseEntity getCardByTitle (@RequestParam String title){
        return ResponseEntity.ok(productService.getCardsByTitle(title));
    }

    @ApiOperation(value = "Find product cards by user", notes = "Find all product cards from the user")
    @GetMapping("/user")
    public ResponseEntity getCardsByUser(@RequestParam UserEntity id){
        return ResponseEntity.ok(productService.getCardsByUser(id));
    }

    @ApiOperation(value = "Delete product card", notes = "Delete the product card")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductCard(@PathVariable Long id){
        try {
            return ResponseEntity.ok(productService.deleteProductCard(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }


}
