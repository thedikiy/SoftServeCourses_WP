package com.softserve.edu.dao.impl;


import com.softserve.edu.dao.ElementDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ElementDAOImpl<E> implements ElementDAO<E> {
    private Class<E> elementClass;

    public ElementDAOImpl(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    public void addElement(E element) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(element);
            transaction.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateElement(E element) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(element);
            transaction.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public E getElementByID(int elementID) {
        Session session = null;
        E element = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            element =
                    session.get(elementClass, elementID);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }

        }
        return element;
    }

    public List<E> getAllElements() {
        Session session = null;
        List<E> eList;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Query query = session.createQuery("From " + elementClass.getName());
            eList = query.getResultList();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }

        }
        return eList;
    }

    public void deleteElement(Object element) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(element);
            transaction.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }

        }
    }
}
