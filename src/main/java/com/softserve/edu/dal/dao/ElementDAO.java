package com.softserve.edu.dal.dao;

import org.hibernate.Session;

import java.util.List;

interface ElementDAO<E> {
    void addElement(E element);

    void updateElement(E element);

    E getElementByID(int elementID);

    List<E> getAllElements();

    void deleteElement(E element);
}
