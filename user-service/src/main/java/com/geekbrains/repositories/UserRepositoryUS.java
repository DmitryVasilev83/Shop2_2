package com.geekbrains.repositories;


import contract.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryUS extends CrudRepository<User, Long> {

    User findOneByUserName(String userName);

    List<User> findAll();



}
