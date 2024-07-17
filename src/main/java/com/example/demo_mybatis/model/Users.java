package com.example.demo_mybatis.model;
// 这里是对应的sql 里面的Users table
public class Users {
    private Integer id;
    private String username; // 注意在sql 中是user_name, 这里是username
    private String email;

    public Users(Integer id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
