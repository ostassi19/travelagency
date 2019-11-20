package com.ditracademy.travelagency1.core.destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DestinationController {


    @Autowired
    DestinationServices destinationServices;

    @PostMapping("/destination")
    public ResponseEntity<?> creatDestination(@RequestBody Destination destination){// userTepository manipule que l'objet user
        return destinationServices.creatDestination(destination);
    }


    @GetMapping("/destinations")
    public List<Destination>  getDestinations(){
        return destinationServices.getDestinations();
    }


    @GetMapping("destination/{id}")
    public ResponseEntity<?>   getOneDestination(@PathVariable int id ){

        return destinationServices.getOneDestination(id);
    }


    @DeleteMapping("/destination/{id}")
    public ResponseEntity<?> deleteDestination(@PathVariable int id)
    {
        return destinationServices.deleteDestination(id);
    }


    @PutMapping("destintion/{id}")
    public ResponseEntity<?> updateDestination(@PathVariable int id, @RequestBody Destination destination)
    {
        return destinationServices.updateDestination(id,destination);
    }






}
