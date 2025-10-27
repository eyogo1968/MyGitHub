package com.example.centreformation.service;

import java.util.List;

public interface CrudService<T, PK> {

    public List<T> findAll();
    public T findById(PK id);
    public T create(T item);
    public void update(T item);
    public T delete(PK id);
}
