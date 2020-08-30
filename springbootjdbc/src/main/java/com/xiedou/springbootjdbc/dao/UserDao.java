package com.xiedou.springbootjdbc.dao;

import com.xiedou.springbootjdbc.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(Users users){
        String sql="insert into user(username,password,sex) values(?,?,?)";
        this.jdbcTemplate.update(sql,users.getUsername(),users.getPassword(),users.getSex());

    }

    public List<Users> findUserAll(){
        String sql="select * from user";
        return  this.jdbcTemplate.query(sql, new RowMapper<Users>() {
            //映射结果集
            @Override
            public Users mapRow(ResultSet resultSet, int i) throws SQLException {
                Users users=new Users();
                users.setUsername(resultSet.getString("username"));
                users.setPassword(resultSet.getString("password"));
                users.setSex(resultSet.getString("sex"));
                return users;
            }
        });
    }

    public Users findUserByName(String username){
        Users users=new Users();
        String sql="select t.* from user t where t.username=?";
        Object[] arr=new Object[]{username};
        this.jdbcTemplate.query(sql,arr, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                users.setUsername(resultSet.getString("username"));
                users.setPassword(resultSet.getString("password"));
                users.setSex(resultSet.getString("sex"));
            }
        });
        return  users;

    }

    public void updateUser(Users users){
        String sql="update user t set t.username=?,t.password=?,t.sex=? where t.username=?";
        this.jdbcTemplate.update(sql,users.getUsername(),users.getPassword(),users.getSex(),users.getUsername());
    }
    public void deleteUser(String username){
        String sql="delete from user where username=?";
        this.jdbcTemplate.update(sql,username);
    }
}
