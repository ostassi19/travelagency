package com.ditracademy.travelagency1.core.voyage;


import com.ditracademy.travelagency1.core.destination.Destination;
import com.ditracademy.travelagency1.utils.Audible;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter// lombok génère les getter setter et noarg
@Setter
@NoArgsConstructor()
@Where(clause ="deleted=false ")
@SQLDelete(sql =" update voyage set deleted = true where id =?")

public class Voyage extends Audible { //classe antité
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;
    private String description;
    private Integer nbPlaces;
    private Float prix;
    private Date date;
    private boolean deleted=false;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Destination destination;


}

