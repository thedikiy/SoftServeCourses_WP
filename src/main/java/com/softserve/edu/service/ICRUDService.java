package com.softserve.edu.service;

import java.util.List;

public interface ICRUDService<E> {
    void addElement(E element);

    void updateElement(E element);

    E getElementByID(int elementID);

    List<E> getAllElements();

    void deleteElement(E element);
}
