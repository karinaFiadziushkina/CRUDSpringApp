package com.app.crud.CarShopSpring.repository;

import com.app.crud.CarShopSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}