package com.ditracademy.travelagency1.core.chambre;

import com.ditracademy.travelagency1.core.Chambres.type_chambre.Type_chambre;
import com.ditracademy.travelagency1.core.categorie_chambre.Categorie_chambre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor()

@Table(uniqueConstraints = {
        @UniqueConstraint( columnNames = {"categorie_chambre_id","type_chambre_id"})
})

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Type_chambre typeChambre;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Categorie_chambre categorieChambre;
}
