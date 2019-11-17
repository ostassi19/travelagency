package com.ditracademy.travelagency1.core.user;

import com.ditracademy.travelagency1.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices { // implémentation des méthodes qui sera impliquer sur le user
    @Autowired

    UserRepository userRepository;// liaison entre controller et userrepository

    public ResponseEntity<?> createUser( User user){// userTepository manipule que l'objet user

        if(user.getName()== null){
            return new ResponseEntity<> (new ErrorResponseModel("User name required  "), HttpStatus.BAD_REQUEST);
        }

        if(user.getName().length()<3){
            return new ResponseEntity<> (new ErrorResponseModel ("Wrong user name   "),HttpStatus.BAD_REQUEST);
        }

        if(user.getAge()==null){
            return new ResponseEntity<> (new ErrorResponseModel ("User age required   "),HttpStatus.BAD_REQUEST);
        }

        if(user.getAge()<0 || user.getAge()>200){
            return new ResponseEntity<> (new ErrorResponseModel ("wrong user age   "),HttpStatus.BAD_REQUEST);
        }


        User user1=  userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById( int id)// Optional<User>lot contenent des classes
    {
        return userRepository.findById(id);
    }

    public ResponseEntity<?>   getOneUser( int id ){
        Optional<User> userOptional=userRepository.findById(id);
        User user = userOptional.get();

        if(!userOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("User not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);


        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    public ResponseEntity<?> deleteUser( int id)
    {

        Optional<User> userOptional=userRepository.findById(id);
        if(!userOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("User not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);



        }

        userRepository.deleteById(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }


    public ResponseEntity<?> updateUser( int id,User user)
    {
        Optional<User> userOptional= userRepository.findById(id);
        User dataBaseUser= userOptional.get();

        if(!userOptional.isPresent()){
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("User not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        if (user.getName() == null)
            return new ResponseEntity<>(new ErrorResponseModel("User name required  "), HttpStatus.BAD_REQUEST);

        if (user.getName().length() < 3)
            return new ResponseEntity<>(new ErrorResponseModel("wrong User name "), HttpStatus.BAD_REQUEST);
        dataBaseUser.setName(user.getName());

        if(user.getAge()!= null)
            return new ResponseEntity<> (new ErrorResponseModel ("User age required "),HttpStatus.BAD_REQUEST);

        if(user.getAge()<0 || user.getAge()>200)
            return new ResponseEntity<> (new ErrorResponseModel ("wrong User age "),HttpStatus.BAD_REQUEST);

        dataBaseUser.setAge(user.getAge());

        userRepository.save(dataBaseUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<?> usersConditionalAge( )
    {
        List<User> userList = userRepository.findAllByAgeIsLessThan(20);
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

}
