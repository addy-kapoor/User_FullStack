package com.codeWithAditi.fullstack_backend.controller;

import com.codeWithAditi.fullstack_backend.exception.UserNotFoundException;
import com.codeWithAditi.fullstack_backend.model.User;
import com.codeWithAditi.fullstack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @PostMapping("/user")
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Long id){
       return userRepository.findById(id)
               .orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    public String saveUser(@PathVariable Long id){
        if(!userRepository.existsById(id))
            throw new UserNotFoundException(id);
        userRepository.deleteById(id);
        return "User successfuly deleted with id "+id;
    }

}
