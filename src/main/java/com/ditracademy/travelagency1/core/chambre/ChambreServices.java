package com.ditracademy.travelagency1.core.chambre;

import com.ditracademy.travelagency1.core.Chambres.type_chambre.Type_chambre;
import com.ditracademy.travelagency1.core.Chambres.type_chambre.Type_chambreRepository;
import com.ditracademy.travelagency1.core.categorie_chambre.Categorie_chambre;
import com.ditracademy.travelagency1.core.categorie_chambre.Categorie_chambreRepository;
import com.ditracademy.travelagency1.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ChambreServices {

    @Autowired
    ChambreRepository chambreRepository;

    @Autowired
    Categorie_chambreRepository categorie_chambreRepository;

    @Autowired
    Type_chambreRepository type_chambreRepository;

    public ResponseEntity<?> createChambre(Chambre chambre) {

        Optional<Categorie_chambre> categorie_chambreOptional = categorie_chambreRepository.findById(chambre.getCategorieChambre().getId());
        if(categorie_chambreOptional.isPresent()){
            return new ResponseEntity<>(new ErrorResponseModel("categorie not found"), HttpStatus.BAD_REQUEST);
        }

        Optional<Type_chambre> type_chambreOptional =type_chambreRepository.findById(chambre.getTypeChambre().getId());

        if(!type_chambreOptional.isPresent()){
            return new ResponseEntity<>(new ErrorResponseModel("type not found"), HttpStatus.BAD_REQUEST);
        }


        Optional<Chambre> chambreOptional = chambreRepository.findByCategorieChambreAndTypeChambre(categorie_chambreOptional.get(),type_chambreOptional.get());
        if(chambreOptional.isPresent()){
            return new ResponseEntity<>(new ErrorResponseModel("chambre not found"), HttpStatus.BAD_REQUEST);
        }

       /* try {
             chambre= chambreRepository.save(chambre);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(new ErrorResponseModel(exception.getMessage()),HttpStatus.BAD_REQUEST);
        }*/


        chambre=  chambreRepository.save(chambre);
        return new ResponseEntity<>(chambre, HttpStatus.OK);
    }

    public List<Chambre> getAllChambre() {
        return  chambreRepository.findAll();
    }

    public ResponseEntity<?> getOneChambre(int id) {
        Optional<Chambre> chambreOptional=chambreRepository.findById(id);

        if(!chambreOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("Destination not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        Chambre chambre = chambreOptional.get();

        return new ResponseEntity<>(chambre, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteChambre(int id) {
        Optional<Chambre> chambreOptional = chambreRepository.findById(id);
        if(!chambreOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("Destinayion not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        chambreRepository.deleteById(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }

    public ResponseEntity<?> updateChambre(int id, Chambre chambre) {
        Optional<Chambre> chambreOptional= chambreRepository.findById(id);

        if(!chambreOptional.isPresent()){
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("destination not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        Chambre dataBaseChambre= chambreOptional.get();

//        if(chambre.getDescription() != null)
//            dataBaseDestination.setDescription(destination.getDescription());
//        if(destination.getNom()!= null)
//            dataBaseDestination.setNom(destination.getNom());

        chambreRepository.save(dataBaseChambre);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
