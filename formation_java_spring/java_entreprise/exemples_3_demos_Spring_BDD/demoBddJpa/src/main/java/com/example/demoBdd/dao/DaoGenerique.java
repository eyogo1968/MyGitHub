package com.example.demoBdd.dao;

import java.util.List;

public interface DaoGenerique<T,PK> {

    List<T> getAll();

    T getById(PK id);

    T create(T obj);

    void update(T obj);

    T delete(PK id);
}
