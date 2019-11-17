package com.ditracademy.travelagency1.core.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// userrepository a pour but de manipuler la base de donnée
public interface UserRepository extends JpaRepository<User,Integer>
        //intermidiaire entre classe java et hibernate<objet de classe entitée,type de id>
    //point de contact entre Controller et hibernate
    //jpa internidiaire entre repository et hibernate
{
        List<User> findAllByAgeIsLessThan(int age);// création d'une requette spécialisée
}
