package com.softserve.edu.service.impl;

import com.softserve.edu.dao.ElementDAO;
import com.softserve.edu.service.ICRUDService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public abstract class AbstractCRUDService<E> implements ICRUDService<E> {
    private ElementDAO<E> elementDAO;

    public AbstractCRUDService(ElementDAO elementDAO) {
        this.elementDAO = elementDAO;
    }

    @Transactional
    public void addElement(E element) {
        elementDAO.addElement(element);
    }

    @Transactional
    public void updateElement(E element) {
        elementDAO.updateElement(element);
    }

    @Transactional
    public E getElementByID(int elementID) {
        return elementDAO.getElementByID(elementID);
    }

    @Transactional
    public List<E> getAllElements() {
        return elementDAO.getAllElements();
    }

    @Transactional
    public void deleteElement(E element) {
        elementDAO.deleteElement(element);
    }

    public List<E> findByMapRequest(Map<String, String> request) {
        return elementDAO.findByMapRequest(request);
    }
}
