package com.xiedou.springbootmybatis.service;


import com.xiedou.springbootmybatis.entity.User;

import java.util.List;

public interface UserService {
    public void  addUser(User users);

    List<User> findUserAll();

    User findUser(String username);

    void updateUser(User user);

    void  deleteUser(String username);
}
