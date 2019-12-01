package com.ditracademy.travelagency1.core.categorie_chambre;

import com.ditracademy.travelagency1.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Categorie_chambreServices {
    @Autowired
    Categorie_chambreRepository categorie_chambreRepository;

    public ResponseEntity<?> creatCategorie(Categorie_chambre categorie_chambre) {
        categorie_chambre= categorie_chambreRepository.save(categorie_chambre);
        return new ResponseEntity<>(categorie_chambre, HttpStatus.OK);

    }

    public List<Categorie_chambre> getCategories() {
        return categorie_chambreRepository.findAll();
    }

    public ResponseEntity<?> getOneCategorie(int id) {
        Optional<Categorie_chambre> categorie_chambreOptional = categorie_chambreRepository.findById(id);

        if (!categorie_chambreOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("Categorie not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        Categorie_chambre categorie_chambre = categorie_chambreOptional.get();

        return new ResponseEntity<>(categorie_chambre, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteCategorie(int id) {
        Optional<Categorie_chambre> categorie_chambreOptional = categorie_chambreRepository.findById(id);
        if (!categorie_chambreOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("categorie not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        categorie_chambreRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> updateCategorie(int id, Categorie_chambre categorie_chambre) {
        Optional<Categorie_chambre> categorie_chambreOptional = categorie_chambreRepository.findById(id);

        if (!categorie_chambreOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("categorie not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);

        }
        Categorie_chambre dataBaseCategorie= categorie_chambreOptional.get();


        if(categorie_chambre.getDescription() != null)
            dataBaseCategorie.setDescription(categorie_chambre.getDescription());

        if(categorie_chambre.getCategorie() != null)
            dataBaseCategorie.setCategorie(categorie_chambre.getCategorie());

        categorie_chambreRepository.save(dataBaseCategorie);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
