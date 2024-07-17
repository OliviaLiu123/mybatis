package com.example.demo_mybatis;
import com.example.demo_mybatis.mapper.UserMapper;
import com.example.demo_mybatis.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@SpringJUnitConfig
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MapperScan("com.example.demo_mybatis.mapper")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setAge(30);
    }

    @Test
    void testInsertUser() {
        userMapper.insertUser(user);
        User insertedUser = userMapper.getUserById(user.getId());
        assertNotNull(insertedUser);
        assertEquals(user.getName(), insertedUser.getName());
    }

    @Test
    void testUpdateUser() {
        userMapper.insertUser(user);
        user.setName("John Doe Updated");
        userMapper.updateUser(user);
        User updatedUser = userMapper.getUserById(user.getId());
        assertNotNull(updatedUser);
        assertEquals("John Doe Updated", updatedUser.getName());
    }

    @Test
    void testDeleteUser() {
        userMapper.insertUser(user);
        userMapper.deleteUser(user.getId());
        User deletedUser = userMapper.getUserById(user.getId());
        assertEquals(null, deletedUser);
    }

    @Test
    void testFindUserByConditions() {
        userMapper.insertUser(user);
        Map<String, Object> params = new HashMap<>();
        params.put("userName", "John Doe");
        params.put("age", 30);
        User foundUser = (User) userMapper.findUserByConditions(params);
        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getName());
    }
}

