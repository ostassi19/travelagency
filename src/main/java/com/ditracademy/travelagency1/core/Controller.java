package com.ditracademy.travelagency1.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    UserRepository userRepository;// liaison entre controller et userrepository

    @PostMapping("/user")
    public void createUser(@RequestBody User user){// userTepository manipule que l'objet user
       User user1= new User();
        userRepository.save(user);
        user1.setName("eddddddd");
        //blala
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
