package com.tso7121.telemedicine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tso7121.telemedicine.model.User;
import com.tso7121.telemedicine.repository.UserRepository;
import com.tso7121.telemedicine.service.UserService;
import com.tso7121.telemedicine.util.AuthHandler;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public User createUser(User user) throws Exception {
        // Matcher matcher = PASSWORD_PATTERN.matcher(user.getPassword());
        // boolean isValidPassword = matcher.matches();
        //
        // if (isValidPassword) {
        user.setPassword(AuthHandler.hashPassword(user.getPassword()));
        return userRepository.save(user);
        // } else {
        // throw new UnsupportedOperationException(
        // "Password must be at least 8 characters, contain at least one uppercase letter, one
        // lowercase letter, and one digit.");
        // }
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public User updateUser(int id, User userDetails) {
        return userRepository.save(userDetails);
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public User login(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            boolean isValid = AuthHandler.checkPassword(password, user.getPassword());
            // if (AuthHandler.decrypt(user.getPassword()).equals(password)) {
            if (isValid) {
                return user;
            } else {
                throw new Exception("Incorrect password");
            }
        } else {
            throw new Exception("User not found");
        }
    }
}
