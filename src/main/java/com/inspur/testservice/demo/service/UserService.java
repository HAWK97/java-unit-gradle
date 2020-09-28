package com.inspur.testservice.demo.service;

import com.github.pagehelper.PageInfo;
import com.inspur.testservice.demo.domain.UserDomain;

public interface UserService {
    int addUser(UserDomain user);

    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);

    UserDomain getUser(Integer id);
}
