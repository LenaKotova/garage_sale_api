package com.portfolio.garagesale.entities;
import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "usr")
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "user_id", unique = true)
    private long id;

    @NonNull @Column(nullable = false)
    private String name;
    @NonNull @Column(nullable = false, unique = true)
    private String login;
    @NonNull @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<ProductCardEntity> productCards;

}
