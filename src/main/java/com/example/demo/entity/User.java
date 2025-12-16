package com.example.demo.entity;

@Entity
public class User{

    private long id;

    private String name;
    
    private String email;

    private String password;

    private String role;

    public User(){}

    public User(long id,String name,String email,String password,String role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void setId(long id){
        this.id = id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPassword(String )
}