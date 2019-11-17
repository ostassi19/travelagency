package com.ditracademy.travelagency1.core.voyage;

import com.ditracademy.travelagency1.core.destination.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoyageRepository extends JpaRepository<Voyage,Integer> {
}
