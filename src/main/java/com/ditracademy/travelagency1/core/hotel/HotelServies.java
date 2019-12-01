package com.ditracademy.travelagency1.core.hotel;


import com.ditracademy.travelagency1.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class HotelServies {
    @Autowired
    HotelRepository hotelRepository;

    public ResponseEntity<?> createHotel(Hotel hotel) {
        hotel = hotelRepository.save(hotel);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    public ResponseEntity<?> getOneHotel(int id) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);

        if (!hotelOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("Hotel not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        Hotel hotel = hotelOptional.get();

        return new ResponseEntity<>(hotel, HttpStatus.OK);

    }

    public ResponseEntity<?> deleteHotel(int id) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        if (!hotelOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("Hotel not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        hotelRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<?> updateHotel(int id, Hotel hotel) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);

        if (!hotelOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("hotel not found");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);

        }
        Hotel dataBaseHotel= hotelOptional.get();


        hotelRepository.save(dataBaseHotel);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
