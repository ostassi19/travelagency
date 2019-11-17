package com.ditracademy.travelagency1.core.voyage;

import com.ditracademy.travelagency1.core.destination.Destination;
import com.ditracademy.travelagency1.core.destination.DestinationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class VoyageController {

    @Autowired
    VoyageServices voyageServices;

    @PostMapping("/voyage")
    public ResponseEntity<?> createVoyage(@RequestBody Voyage voyage){// userTepository manipule que l'objet user
        return voyageServices.createVoyage(voyage);
    }

    @GetMapping("/voyages")
    public List<Voyage> getVoyages(){
        return voyageServices.getVoyages();
    }

    @GetMapping("voyage/{id}")
    public ResponseEntity<?>   getOneVoyage(@PathVariable int id ){

        return voyageServices.getOneVoyage(id);
    }

    @DeleteMapping("/voyage/{id}")
    public ResponseEntity<?> deleteVoyage(@PathVariable int id) {
        return voyageServices.deleteVoyage(id);
    }


    @PutMapping("voyage/{id}")
    public ResponseEntity<?> updateVoyage(@PathVariable int id, @RequestBody Voyage voyage) {
        return voyageServices.updateVoyage(id,voyage);
    }
}
