package com.ditracademy.travelagency1.core.Chambres.type_chambre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Type_chambreController {
    @Autowired
    Type_chambreServices type_chambreServices;

    @PostMapping("/type")

    public ResponseEntity<?> createType(@RequestBody Type_chambre type_chambre){// userTepository manipule que l'objet user
        return type_chambreServices.createType(type_chambre);
    }

    @GetMapping("/types")
    public List<Type_chambre> getAllTypes(){// userTepository manipule que l'objet user
        return type_chambreServices.getAllTypes();
    }

    @GetMapping("type/{id}")
    public ResponseEntity<?>   getOneType(@PathVariable int id ){

        return type_chambreServices.getOneType(id);
    }


    @DeleteMapping("/type/{id}")
    public ResponseEntity<?> deleteType(@PathVariable int id)
    {
        return type_chambreServices.deleteType(id);
    }


    @PutMapping("type/{id}")
    public ResponseEntity<?> updateType(@PathVariable int id, @RequestBody Type_chambre type_chambre)
    {
        return type_chambreServices.updateType(id,type_chambre);
    }

}
