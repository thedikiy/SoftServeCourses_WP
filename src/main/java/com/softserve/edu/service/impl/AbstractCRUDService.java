package com.softserve.edu.service.impl;

import com.softserve.edu.dao.ElementDAO;
import com.softserve.edu.service.ICRUDService;

import java.util.List;

public abstract class AbstractCRUDService<E> implements ICRUDService<E> {
    private ElementDAO<E> elementDAO;

    public AbstractCRUDService(ElementDAO elementDAO) {
        this.elementDAO = elementDAO;
    }

    public void addElement(E element){
        elementDAO.addElement(element);
    }

    public void updateElement(E element) {
        elementDAO.updateElement(element);
    }

    public E getElementByID(int elementID) {
       return (E)elementDAO.getElementByID(elementID);
    }

    public List<E> getAllElements() {
        return elementDAO.getAllElements();
    }

    public void deleteElement(E element) {
        elementDAO.deleteElement(element);
    }
}
