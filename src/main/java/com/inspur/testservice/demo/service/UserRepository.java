package com.inspur.testservice.demo.service;

import com.inspur.testservice.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);
}
