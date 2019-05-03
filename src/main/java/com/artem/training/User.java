package com.artem.training;

import java.util.List;

public class User {


    private long id;
    private int age;
    private String name;

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

    @Override
    public String toString() {
        return "ID: " + this.getId() + "; " + "Name: " + this.getName() + "; " + "Age: " + this.getAge() + "; " + "Children: " + this.getChildren();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int second = 17;
        prime = prime * second + getName().hashCode();
        prime = prime * second + getAge();
        return prime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return this.id == user.id &&
                this.age == user.age &&
                this.name.equals(user.name);
    }
}




