package com.ditracademy.travelagency1.core.voyage;

import com.ditracademy.travelagency1.core.destination.Destination;
import com.ditracademy.travelagency1.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class VoyageServices {

    @Autowired
    VoyageRepository voyageRepository;


    public ResponseEntity<?> createVoyage( Voyage voyage) {
        voyage=  voyageRepository.save(voyage);
        return new ResponseEntity<>(voyage, HttpStatus.OK);
    }

    public List<Voyage> getVoyages(){
        return voyageRepository.findAll();
    }


    public ResponseEntity<?>   getOneVoyage( int id ){
        Optional<Voyage> voyageOptional=voyageRepository.findById(id);

        if(!voyageOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("voyage not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        Voyage voyage = voyageOptional.get();

        return new ResponseEntity<>(voyage, HttpStatus.OK);
    }


    public ResponseEntity<?> deleteVoyage( int id) {

        Optional<Voyage> voyageOptional = voyageRepository.findById(id);
        if(!voyageOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("voyage not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        voyageRepository.deleteById(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }


    public ResponseEntity<?> updateVoyage( int id,  Voyage voyage) {
        Optional<Voyage> voyageOptional= voyageRepository.findById(id);

        if(!voyageOptional.isPresent()){
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("voyage not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        Voyage dataBaseVoyage= voyageOptional.get();

        if(voyage.getDescription() != null)
            dataBaseVoyage.setDescription(voyage.getDescription());

        if(voyage.getTitre()!=null)
            dataBaseVoyage.setTitre(voyage.getTitre());

        if(voyage.getDescription()!=null)
            dataBaseVoyage.setDescription(voyage.getDescription());

        if(voyage.getDate()!=null)
            dataBaseVoyage.setDate(voyage.getDate());


        voyageRepository.save(dataBaseVoyage);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
