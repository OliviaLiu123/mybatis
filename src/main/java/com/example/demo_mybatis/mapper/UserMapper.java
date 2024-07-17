package com.example.demo_mybatis.mapper;

import com.example.demo_mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface UserMapper {

    void insertUser(User user);
    User getUserById(int id);

    void updateUser(User user);
    void deleteUser(int id);

    List<User> findUserByConditions(Map<String, Object> params);

    @Select("SELECT * FROM user WHERE id =#{id}")
    @Results({
            @Result(property ="id",column = "id"),
            @Result(property="username",column="user_name"),
            @Result(property="email",column = "email") })
  User selectUserById(Integer id);
    @Results({
            @Result(property = "id",column="id"),
            @Result(property = "username",column="user_name"),
            @Result(property ="email",column = "email")

    })

    List<User> selectAllUsers();

}
