package com.ditracademy.travelagency1.core.Chambres.type_chambre;

import com.ditracademy.travelagency1.core.categorie_chambre.Categorie_chambre;
import com.ditracademy.travelagency1.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Type_chambreServices {
    @Autowired
    Type_chambreRepository type_chambreRepository;
    public ResponseEntity<?> createType(Type_chambre type_chambre) {
        type_chambre= type_chambreRepository.save(type_chambre);
        return new ResponseEntity<>(type_chambre, HttpStatus.OK);
    }

    public List<Type_chambre> getAllTypes() {
        return type_chambreRepository.findAll();    }

    public ResponseEntity<?> getOneType(int id) {
        Optional<Type_chambre> type_chambreOptional = type_chambreRepository.findById(id);

        if (!type_chambreOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("type not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        Type_chambre type_chambre = type_chambreOptional.get();

        return new ResponseEntity<>(type_chambre, HttpStatus.OK);

    }

    public ResponseEntity<?> deleteType(int id) {
        Optional<Type_chambre> type_chambreOptional = type_chambreRepository.findById(id);
        if (!type_chambreOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("type not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        type_chambreRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<?> updateType(int id, Type_chambre type_chambre) {
        Optional<Type_chambre> type_chambreOptional = type_chambreRepository.findById(id);

        if (!type_chambreOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("type not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);

        }
        Type_chambre dataBaseType= type_chambreOptional.get();


        if(type_chambre.getDescription() != null)
            dataBaseType.setDescription(type_chambre.getDescription());

        if(type_chambre.getType() != null)
            dataBaseType.setType(type_chambre.getType());


        type_chambreRepository.save(dataBaseType);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
