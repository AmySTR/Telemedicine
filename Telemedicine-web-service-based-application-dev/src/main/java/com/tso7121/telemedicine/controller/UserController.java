package com.tso7121.telemedicine.controller;

import java.util.List;

import com.tso7121.telemedicine.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tso7121.telemedicine.model.User;
import com.tso7121.telemedicine.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@PostMapping
	public User createUser(@RequestBody User user) throws Exception {
		return userService.createUser(user);
	}

	@PostMapping("/login")
	public User login(@RequestBody LoginRequest loginRequest) throws Exception {
		return userService.login(loginRequest.getEmail(), loginRequest.getPassword());
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User userDetails) {
		return userService.updateUser(id, userDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}
