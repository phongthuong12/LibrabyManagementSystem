/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.User;

/**
 *
 * @author Phong
 */
public class UserCollection implements I_Collection<User> {

    private Map<String, User> users;

    public UserCollection() {
        users = new HashMap<>();
    }

    @Override
    public void add(User user) {
        users.put(user.getUserId(), user);
    }

    @Override
    public void update(User user) {
        if (users.containsKey(user.getUserId())) {
            users.put(user.getUserId(), user);
        }
    }

    @Override
    public void delete(String id) {
        if (users.containsKey(id)) {
            User user = users.get(id);
            user.setActiveUser(false);
            users.put(id, user);
        }
    }

    @Override
    public User getById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        List<User> activeUsers = new ArrayList<>();
        for (User user : users.values()) {
            if (user.isActiveUser()) {
                activeUsers.add(user);
            }
        }
        return activeUsers;
    }
}
