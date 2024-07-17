package com.example.demo_mybatis.service;


import com.example.demo_mybatis.mapper.UserMapper;
import com.example.demo_mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    //create
    public void  createUser(User user){
        userMapper.insertUser(user);

    }
    //read
    public User readUserById(int id){
        return userMapper.getUserById(id);
    }

    //update
    @Transactional
    public void updateUser(User user){
        userMapper.updateUser(user);
    }
    //delete
    @Transactional
    public void deleteUser(int id){
        userMapper.deleteUser(id);
    }

    public User getUserById(Integer id){
        return userMapper.selectUserById(id);
    }
    public List<User> getAllUsers(){
        return userMapper.selectAllUsers();
    }

    //动态查找
    public List<User> findUserByConditions(String userName, Integer age){
        Map<String ,Object> params = new HashMap<>();
        params.put("userName",userName);
        params.put("age",age);
        return userMapper.findUserByConditions(params);
    }
}
