package com.artem.training;

import java.util.List;

public class User {


    long id;
    int age;
    String name;

    public long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<User> getChildren() {
        return children;
    }

    private List<User> children;


    public User(long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public User(long id, int age, String name, List<User> children) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.children = children;
    }

    public String toString() {
        return "ID: " + this.getId() + "; " + "Name: " + this.getName() + "; " + "Age: " + this.getAge() + "; " + "Children: " + this.getChildren();
    }


}




