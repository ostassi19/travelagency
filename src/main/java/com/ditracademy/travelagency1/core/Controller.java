package com.ditracademy.travelagency1.core;

import com.ditracademy.travelagency1.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController

public class Controller { // routage entre les méthodes et les requettes.

    @Autowired
    UserRepository userRepository;// liaison entre controller et userrepository

    @Autowired
    UserServices userServices;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user){// userTepository manipule que l'objet user
        return userServices.createUser(user);
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return userServices.getUsers();
    }


    @GetMapping("/userid/{id}")
    public Optional<User> getUserById(@PathVariable int id)// Optional<User>lot contenent des classes
    {
        return userServices.getUserById(id);
    }


    @GetMapping("user/{id}")
    public ResponseEntity<?>   getOneUser(@PathVariable int id ){

       return userServices.getOneUser(id);
    }



    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id)
    {
        return userServices.deleteUser(id);
    }




    @PutMapping("user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user)
    {
      return userServices.updateUser(id,user);
    }


    @GetMapping("userConditionalAge")

    public ResponseEntity<?> usersConditionalAge( )
    {
        return userServices.usersConditionalAge();
    }



}
