package com.softserve.edu.dao;

import java.util.List;

public interface ElementDAO<E> {
    void addElement(E element);

    void updateElement(E element);

    E getElementByID(int elementID);

    List<E> getAllElements();

    void deleteElement(E element);

    E findUserByName(String table, String column, String name);
}
