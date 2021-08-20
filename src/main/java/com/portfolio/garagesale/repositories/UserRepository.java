package com.portfolio.garagesale.repositories;

import com.portfolio.garagesale.entities.UserEntity;
import org.springframework.data.repository.*;

public interface UserRepository extends CrudRepository <UserEntity, Long>{
    UserEntity findByName(String userName);
    UserEntity findByLogin(String userLogin);
}
