package com.ditracademy.travelagency1.core.voyage;

import com.ditracademy.travelagency1.core.destination.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoyageRepository extends JpaRepository<Voyage,Integer> {
  //  List<Voyage> findAllByNbPlacesIsNotAndPrixBetween(int x,Float min,Float max);
    @Query(value = "SELECT * from voyage where nb_places != ?2 and prix> ?1", nativeQuery = true) // JPQl==> Sql
    List<Voyage> findAllByQuerry(@Param("price") Float price, @Param("nbPlaces") Integer nbPalaces);

}
