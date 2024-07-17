package com.example.demo_mybatis.controller;


import com.example.demo_mybatis.model.User;
import com.example.demo_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //创建用户
    @PostMapping("")
    public void createUser(@RequestBody User user){
        userService.createUser(user);

    }

    //读取用户
    @GetMapping("/{id}")
    public User readUser(@PathVariable int id ){

       return  userService.readUserById(id);
    }

    // update user
    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user){
        user.setId(id); // 假设前端没有发送id, 我们从路径中获取并设置到user 对象中
        userService.updateUser(user);
    }

    //delete user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

}
