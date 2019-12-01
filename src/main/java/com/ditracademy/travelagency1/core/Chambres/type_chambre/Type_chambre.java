package com.ditracademy.travelagency1.core.Chambres.type_chambre;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor()
public class Type_chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String type;
    String description;


}
