package com.thoughtworks.repository;

import com.thoughtworks.domain.User;
import com.thoughtworks.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void postUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Invalid User Format");
        }
        UserStorage.postUser(user);
    }
}
