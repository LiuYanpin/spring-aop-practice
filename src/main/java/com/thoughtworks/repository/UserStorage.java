package com.thoughtworks.repository;

import com.thoughtworks.domain.User;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private static final Map<Integer, User> USERS = new HashMap<>();

    public static void postUser(User user) {
        USERS.put(user.getId(), user);
    }
}
