package com.ditracademy.travelagency1.core.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {
    @Autowired
    HotelServies hotelServies;

    @PostMapping("/hotel")

    public ResponseEntity<?> createHotel(@RequestBody Hotel hotel){// userTepository manipule que l'objet user
        return hotelServies.createHotel(hotel);
    }

    @GetMapping("/hotels")
    public List<Hotel> getAllHotel(){// userTepository manipule que l'objet user
        return hotelServies.getAllHotel();
    }

    @GetMapping("hotel/{id}")
    public ResponseEntity<?>   getOneHotel(@PathVariable int id ){

        return hotelServies.getOneHotel(id);
    }


    @DeleteMapping("/hotel/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable int id)
    {
        return hotelServies.deleteHotel(id);
    }


    @PutMapping("hotel/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable int id, @RequestBody Hotel hotel)
    {
        return hotelServies.updateHotel(id,hotel);
    }

}
