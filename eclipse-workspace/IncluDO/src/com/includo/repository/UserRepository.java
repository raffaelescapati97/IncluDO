package com.includo.repository;

import java.util.ArrayList;

import com.includo.model.User;

public class UserRepository {

    private ArrayList<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findById(int id) {

        for (User user : users) {

            if (user.getId() == id) {
                return user;
            }

        }

        return null;
    }
    
    public int getNextId() {

        int max = 0;

        for (User user : users) {

            if (user.getId() > max) {
                max = user.getId();
            }
        }

        return max + 1;
    }
}