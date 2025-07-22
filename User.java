package com.test;

public class User {
    private String username;
    private String email;
    private int age;
    
    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
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
        // 이메일 유효성 검증 없음
        this.email = email;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        // 나이 범위 검증 없음
        this.age = age; // 음수나 비현실적인 값 가능
    }
    
    @Override
    public String toString() {
        return "User{username='" + username + "', email='" + email + "', age=" + age + "}";
    }
    
    // equals, hashCode 구현 없음 (컬렉션 사용시 문제 가능성)
}