package com.book.room.demo.service;

import com.book.room.demo.model.User;

public interface UserService {
    public void addUser(User user);
    public User getUser(Long userId);
}
