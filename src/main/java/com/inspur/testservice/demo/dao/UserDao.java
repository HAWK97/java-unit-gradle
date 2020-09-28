package com.inspur.testservice.demo.dao;

import com.inspur.testservice.demo.domain.UserDomain;

import java.util.List;

public interface UserDao {
    int insert(UserDomain record);

    List<UserDomain> selectUsers();

    UserDomain get(int id);
}
