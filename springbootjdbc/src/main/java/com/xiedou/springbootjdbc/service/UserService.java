package com.xiedou.springbootjdbc.service;

import com.xiedou.springbootjdbc.pojo.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    public void  addUser(Users users);

    public List<Users> findUserAll();

    public Users findUserByName(String username);

    public void updateUser(Users users);

    public void deleteUser(String username);
}
