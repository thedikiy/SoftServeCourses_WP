package com.softserve.edu.dao.impl;


import com.softserve.edu.dao.ElementDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

public class ElementDAOImpl<E> implements ElementDAO<E> {
    private Class<E> elementClass;
    private SessionFactory sessionFactory;

    public ElementDAOImpl(Class<E> elementClass, SessionFactory sessionFactory) {
        this.elementClass = elementClass;
        this.sessionFactory = sessionFactory;
    }

    public void addElement(E element) {
        sessionFactory.getCurrentSession().save(element);
    }

    public void updateElement(E element) {
        sessionFactory.getCurrentSession().update(element);
    }

    public List<E> findByName(String table, String column, String name) {
        List<E> eList;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from " + table + " where " + column + " = :string";
        Query<E> query = session.createQuery(hql, elementClass)
                .setParameter("string", name);
        eList = query.getResultList();
        return eList;
    }

    public E getElementByID(int elementID) {
        return sessionFactory.getCurrentSession().get(elementClass, elementID);
    }

    public List<E> getAllElements() {
        List<E> eList;
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(elementClass);
        Root<E> root = cq.from(elementClass);
        cq.select(root);
        Query<E> q = session.createQuery(cq);
        eList = q.getResultList();
        return eList;
    }

    public void deleteElement(Object element) {
        sessionFactory.getCurrentSession().delete(element);
    }

    public List<E> findByMapRequest(Map<String, String> request) {
        List<E> eList = null;
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(elementClass);
        Root<E> root = cq.from(elementClass);
        PredicateFactory<E> factory = new PredicateFactory<E>(elementClass);
        cq.where(factory.createStringPredicates(request, cb, cq, root));
        Query<E> query = session.createQuery(cq);
        eList = query.getResultList();
        return eList;
    }
}
