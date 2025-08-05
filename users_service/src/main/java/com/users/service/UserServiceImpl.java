package com.users.service;

import com.users.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> users = List.of(
        new User(101L, "Alice", "9999999999"),
        new User(102L, "Bob", "8888888888"),
        new User(103L, "Charlie", "7777777777")
    );

    @Override
    public User getUser(Long userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findAny()
                .orElse(null);
    }
}
