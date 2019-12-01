package com.ditracademy.travelagency1.core.categorie_chambre;

import com.ditracademy.travelagency1.core.chambre.Chambre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor()

public class Categorie_chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String categorie;
    String description;


}
