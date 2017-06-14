package com.softserve.edu.service;

import com.softserve.edu.dal.dao.DaoFactory;
import com.softserve.edu.entity.IEntity;

import java.util.List;

public abstract class AbstractService<E> {
    private Class<E>elementClass;

    public AbstractService(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    public void addElement(IEntity iEntity){
        DaoFactory.getInstance().getDAO(elementClass).addElement(iEntity);
    }

    public void updateElement(IEntity iEntity) {
        DaoFactory.getInstance().getDAO(elementClass).updateElement(iEntity);
    }

    public E getElementByID(int elementID) {
       return (E)DaoFactory.getInstance().getDAO(
               elementClass).getElementByID(elementID);
    }

    public List<E> getAllElements() {
        return DaoFactory.getInstance().getDAO(elementClass).getAllElements();
    }

    public void deleteElement(IEntity iEntity) {
        DaoFactory.getInstance().getDAO(elementClass).deleteElement(iEntity);
    }
}
