package com.example.demoboot.repository;

import java.util.List;

/*
 Interface generique
 --->Type_obj est un type generique
 ---> PK est la cle primaire
 ---> Au moment ou je fais mon implementation, je dois lui dire
 ---> c'est quoi le Type_obj
 ---> c'est quoi la cle primaire
 */
public interface Repository<Type_obj, PK> {

    //
    // Les 5 operations CRUD que l'on retrouve toujours dans les repository
    //

    // Operation 1 : On recupere la liste des objets
    List<Type_obj> getAll();

    // Operation 2 :  On recherche un objet avec son id
    Type_obj getById(PK id);

    // Operation 3 :  On cree un objet
    void create(Type_obj item);

    // Operation 4 :  On maj l'objet correspondant a l'id
    void update(PK id, Type_obj item);

    //  Operation 5 : On delete l'objet correspondant a l'id
    Type_obj delete(PK id);
}
