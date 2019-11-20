package com.ditracademy.travelagency1.core.destination;


import com.ditracademy.travelagency1.core.voyage.Voyage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter// lombok génère les getter setter et noarg
@Setter
@NoArgsConstructor()

public class Destination { //classe antité
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String description;
    @JsonIgnore
    @OneToMany( mappedBy = "destination")// il s'agit de  la destination enregistrer dans l'entiter voyage
    private List<Voyage> voyages;


}

