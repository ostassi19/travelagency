package com.ditracademy.travelagency1.core.chambre;

import com.ditracademy.travelagency1.core.Chambres.type_chambre.Type_chambre;
import com.ditracademy.travelagency1.core.categorie_chambre.Categorie_chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChambreRepository extends JpaRepository<Chambre,Integer> {

    Optional<Chambre> findByCategorieChambreAndTypeChambre(Categorie_chambre categorie_chambre, Type_chambre type_chambre);
}
