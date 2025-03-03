package com.coding.jpahibernate.jpahibernate.controller;

import com.coding.jpahibernate.jpahibernate.Entities.User;
import com.coding.jpahibernate.jpahibernate.repo.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    userrepo userRepo;
    @Autowired
    public UserController(userrepo userRepo) {
        this.userRepo = userRepo;
    }
    @GetMapping("/top3")
    public List<User> findTop3ByAgeOrderByLastNameAsc(@RequestParam Integer age){

        return userRepo.findTop3ByAgeOrderByLastNameAsc(age);

    }
    @PostMapping
    public User postData(@RequestBody User user) {
        // Save the user directly using the repository and return the saved entity
        return userRepo.save(user);

    }
}
