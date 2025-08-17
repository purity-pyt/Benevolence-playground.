package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class HelloController {

    private final UserRepository repo;

    public HelloController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Benevolence!";
    }

    @GetMapping("/users")
    public List<User> users() {
        return repo.findAll();
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return repo.save(user);
    }
}
