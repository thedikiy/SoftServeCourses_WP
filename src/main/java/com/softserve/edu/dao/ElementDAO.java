package com.softserve.edu.dao;

import java.util.List;
import java.util.Map;

public interface ElementDAO<E> {
    void addElement(E element);

    void updateElement(E element);

    E getElementByID(int elementID);

    List<E> getAllElements();

    void deleteElement(E element);

    List<E> findByName(String table, String column, String name);

    List<E> findByMapRequest(Map<String, String> request);
}
