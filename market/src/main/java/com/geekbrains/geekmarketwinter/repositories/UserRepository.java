package com.geekbrains.geekmarketwinter.repositories;


import com.geekbrains.geekmarketwinter.entities.User;
import contract.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByUserName(String userName);

    @Transactional
    List<User> findAll();
}
