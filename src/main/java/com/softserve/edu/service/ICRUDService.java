package com.softserve.edu.service;

import java.util.List;
import java.util.Map;

public interface ICRUDService<E> {
    void addElement(E element);

    void updateElement(E element);

    E getElementByID(int elementID);

    List<E> getAllElements();

    void deleteElement(E element);

    List<E> findByMapRequest(Map<String, String> request);
}
