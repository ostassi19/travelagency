package com.ditracademy.travelagency1.core.voyage;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter// lombok génère les getter setter et noarg
@Setter
@NoArgsConstructor()

public class Voyage { //classe antité
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;
    private String description;
    private Integer nbPlaces;
    private Float prix;
    private Date date;





}

