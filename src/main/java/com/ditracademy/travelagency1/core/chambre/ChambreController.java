package com.ditracademy.travelagency1.core.chambre;

import com.ditracademy.travelagency1.core.destination.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ChambreController {
    @Autowired
    ChambreServices chambreServices;

    @PostMapping("/chambre")

    public ResponseEntity<?> createChambre(@RequestBody Chambre chambre){// userTepository manipule que l'objet user
        return chambreServices.createChambre(chambre);
    }

    @GetMapping("/chambres")
    public List<Chambre> getAllChambre(){// userTepository manipule que l'objet user
        return chambreServices.getAllChambre();
    }

    @GetMapping("chambre/{id}")
    public ResponseEntity<?>   getOneChambre(@PathVariable int id ){

        return chambreServices.getOneChambre(id);
    }


    @DeleteMapping("/chambre/{id}")
    public ResponseEntity<?> deleteChambre(@PathVariable int id)
    {
        return chambreServices.deleteChambre(id);
    }


    @PutMapping("chambre/{id}")
    public ResponseEntity<?> updateChambre(@PathVariable int id, @RequestBody Chambre chambre) {
        return chambreServices.updateChambre(id,chambre);
    }



}
