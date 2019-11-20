package com.ditracademy.travelagency1.core.destination;
import com.ditracademy.travelagency1.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationServices {

    @Autowired
    DestinationRepository destinationRepository;

    public ResponseEntity<?> creatDestination( Destination destination){// userTepository manipule que l'objet user

        destination =  destinationRepository.save(destination);
        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    public List<Destination> getDestinations(){
        return destinationRepository.findAll();
    }


    public ResponseEntity<?>   getOneDestination( int id ){
        Optional<Destination> destinationOptional=destinationRepository.findById(id);

        if(!destinationOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("Destination not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        Destination destination = destinationOptional.get();

        return new ResponseEntity<>(destination, HttpStatus.OK);
    }


    public ResponseEntity<?> deleteDestination( int id) {

        Optional<Destination> destinationOptional = destinationRepository.findById(id);
        if(!destinationOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("Destinayion not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        destinationRepository.deleteById(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }


    public ResponseEntity<?> updateDestination( int id,  Destination destination) {
        Optional<Destination> destinationOptional= destinationRepository.findById(id);

        if(!destinationOptional.isPresent()){
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("destination not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        Destination dataBaseDestination= destinationOptional.get();

        if(destination.getDescription() != null)
            dataBaseDestination.setDescription(destination.getDescription());
       if(destination.getNom()!= null)
           dataBaseDestination.setNom(destination.getNom());

        destinationRepository.save(dataBaseDestination);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
