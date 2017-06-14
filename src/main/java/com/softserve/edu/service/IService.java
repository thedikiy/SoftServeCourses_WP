package com.softserve.edu.service;

import com.softserve.edu.entity.IEntity;

public interface IService<E> {
    void addElement(IEntity iEntity);

    void updateElement(IEntity iEntity);

    void getElementByID(int elementID);

    void getAllElements();

    void deleteElement(IEntity iEntity);
}
