package com.xiedou.springbootjdbc.service;

import com.xiedou.springbootjdbc.dao.UserDao;
import com.xiedou.springbootjdbc.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void addUser(Users users) {
        this.userDao.addUser(users);
    }

    @Override
    public List<Users> findUserAll() {
       return this.userDao.findUserAll();

    }

    @Override
    public Users findUserByName(String username) {
        return this.userDao.findUserByName(username);
    }

    @Override
    public void updateUser(Users users) {
         this.userDao.updateUser(users);
    }

    @Override
    public void deleteUser(String username) {
        this.userDao.deleteUser(username);
    }
}
