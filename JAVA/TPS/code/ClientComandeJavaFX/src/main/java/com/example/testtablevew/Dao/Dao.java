package com.example.testtablevew.Dao;

import java.util.List;

public interface Dao<T> {
    public void add(T t);

    public void update(T t);

    public void delete(T t);

    public T findById(int id);

    public List<T> findAll();

    public void deleteAll();

}
