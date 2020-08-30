package com.xiedou.springbootmybatis.service;


import com.xiedou.springbootmybatis.entity.User;
import com.xiedou.springbootmybatis.entity.UserExample;
import com.xiedou.springbootmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional
    public void addUser(User users) {
        this.userMapper.insert(users);
    }

    @Override
    public List<User> findUserAll() {
        UserExample userExample=new UserExample();
       return  this.userMapper.selectByExample(userExample);
    }

    @Override
    public User findUser(String username) {

        return this.userMapper.selectByPrimaryKey(username);
    }

    @Override
    @Transactional
    public void updateUser(User user) {

        this.userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUser(String username) {
        this.userMapper.deleteByPrimaryKey(username);
    }
}
