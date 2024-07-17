package com.example.demo_mybatis.model;

public class OrderCount {
    private Integer userId;
    private String username;

    private Integer orderCount;

    public OrderCount(Integer userId, String username, Integer orderCount) {
        this.userId = userId;
        this.username = username;
        this.orderCount = orderCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }
}
