package com.ditracademy.travelagency1.core.categorie_chambre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Categorie_chambreController {
    @Autowired
    Categorie_chambreServices categorie_chambreServices;

    @PostMapping("/categorie")
    public ResponseEntity<?> creatCategorie(@RequestBody Categorie_chambre categorie_chambre){// userTepository manipule que l'objet user
        return categorie_chambreServices.creatCategorie(categorie_chambre);
    }


    @GetMapping("/categories")
    public List<Categorie_chambre> getCategories(){
        return categorie_chambreServices.getCategories();
    }


    @GetMapping("categorie/{id}")
    public ResponseEntity<?>   getOneCategorie(@PathVariable int id ){

        return categorie_chambreServices.getOneCategorie(id);
    }


    @DeleteMapping("/categorie/{id}")
    public ResponseEntity<?> deleteCategorie(@PathVariable int id)
    {
        return categorie_chambreServices.deleteCategorie(id);
    }


    @PutMapping("categorie/{id}")
    public ResponseEntity<?> updateCategorie(@PathVariable int id, @RequestBody Categorie_chambre categorie_chambre)
    {
        return categorie_chambreServices.updateCategorie(id,categorie_chambre);
    }

}
