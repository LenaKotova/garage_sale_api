package com.portfolio.garagesale.services;

import com.portfolio.garagesale.entities.UserEntity;
import com.portfolio.garagesale.exceptions.UserAlreadyExistsException;
import com.portfolio.garagesale.exceptions.UserNotFoundsException;
import com.portfolio.garagesale.models.User;
import com.portfolio.garagesale.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        if (userRepo.findByLogin(user.getLogin()) != null) {
            throw new UserAlreadyExistsException(user);
        }
        return userRepo.save(user);
    }

    public User getUser(Long id) throws UserNotFoundsException {
        Optional<UserEntity> userEntity = userRepo.findById(id);
        if (!userEntity.isPresent() || userEntity.get() == null) {
            throw new UserNotFoundsException(id);
        }
        return User.toModel(userEntity.get());
    }

    public List<User> getAllUsers(){
        Iterable<UserEntity> entities = userRepo.findAll();
        List <User> users= new ArrayList<>();
        for (UserEntity i: entities) {
            users.add(User.toModel(i));
        }
        return users;
    }

    public User changeUserName(User changedUser, Long id) {
        UserEntity userEntity = userRepo.findById(id).get();
        userEntity.setName(changedUser.getName());
        return User.toModel(userRepo.save(userEntity));
    }

    public Long deleteUser (Long id){
        userRepo.deleteById(id);
        return id;
    }
}
