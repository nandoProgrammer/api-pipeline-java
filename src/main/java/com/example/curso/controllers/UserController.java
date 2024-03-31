package com.example.curso.controllers;

import com.example.curso.entities.User;
import com.example.curso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @ResponseBody
    public void createUser(@RequestBody User newUser) {
        userRepository.save(newUser);
    }

    @GetMapping(path = "/{name}")
    @ResponseBody
    public Iterable<User> getUserByName(@PathVariable String name) {
        return userRepository.findByNameContaining(name);
    }

    @GetMapping(path = "/pageable/{pageNum}")
    @ResponseBody
    public Iterable<User> responseBody(@PathVariable int pageNum){
        Pageable page = PageRequest.of(pageNum, 3);
        return userRepository.findAll(page);
    }
}
