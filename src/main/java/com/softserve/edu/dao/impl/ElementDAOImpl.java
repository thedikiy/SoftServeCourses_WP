package com.softserve.edu.dao.impl;


import com.softserve.edu.dao.ElementDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import java.util.List;


public class ElementDAOImpl<E> implements ElementDAO<E> {
    private Class<E> elementClass;

    private SessionFactory sessionFactory;

    public ElementDAOImpl(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addElement(E element) {
        sessionFactory.getCurrentSession().save(element);
    }

    public void updateElement(E element) {
        sessionFactory.getCurrentSession().update(element);
    }

    public E findUserByName(String table, String column, String name) {
        E element = null;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from " + table + " where " + column + " = :string";
        org.hibernate.query.Query query = session.createQuery(hql, elementClass)
                .setParameter("string", name);
        element = (E) query.getSingleResult();
        return element;
    }

    public E getElementByID(int elementID) {
        return sessionFactory.getCurrentSession().get(elementClass, elementID);
    }

    public List<E> getAllElements() {
        List<E> eList;
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("From " + elementClass.getName());
        eList = query.getResultList();
        return eList;
    }

    public void deleteElement(Object element) {
        sessionFactory.getCurrentSession().delete(element);
    }
}
