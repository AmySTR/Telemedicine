package com.tso7121.telemedicine.service;

import java.util.List;
import com.tso7121.telemedicine.model.User;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    User createUser(User user) throws Exception;

    User updateUser(int id, User userDetails);

    void deleteUser(int id);

    User login(String username, String password) throws Exception;
}
