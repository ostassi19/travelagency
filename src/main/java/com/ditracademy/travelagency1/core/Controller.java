package com.ditracademy.travelagency1.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    UserRepository userRepository;// liaison entre controller et userrepository

    @PostMapping("/user")
    public void createUser(@RequestBody User user){// userTepository manipule que l'objet user
       User user1= new User();
        userRepository.save(user);
        user1.setName("eddddddd");
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/userid/{id}")
    public Optional<User> getUserById(@PathVariable int id)
    {
        return userRepository.findById(id);

    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userRepository.deleteById(id);
    }
    @PutMapping("user/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user)
    {
       User user1= userRepository.findById(id).get();
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        userRepository.save(user1);
    }



}
