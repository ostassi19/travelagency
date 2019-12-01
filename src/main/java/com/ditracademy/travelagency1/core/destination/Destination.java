package com.ditracademy.travelagency1.core.destination;


import com.ditracademy.travelagency1.core.voyage.Voyage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter// lombok génère les getter setter et noarg
@Setter
@NoArgsConstructor()
@Where(clause ="deleted=false ")
@SQLDelete(sql =" update destination set deleted = true where id =?")

public class Destination { //classe antité
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String description;
    private boolean deleted=false;

    @JsonIgnore

    @OneToMany( mappedBy = "destination", cascade = {CascadeType.REMOVE})// il s'agit de  la destination enregistrer dans l'entiter voyage
    private List<Voyage> voyages;


}

