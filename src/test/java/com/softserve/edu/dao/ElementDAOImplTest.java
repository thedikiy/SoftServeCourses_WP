package com.softserve.edu.dao;

import com.softserve.edu.dao.impl.ElementDAOImpl;
import com.softserve.edu.entity.Bus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.testng.annotations.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static org.mockito.Mockito.*;

public class ElementDAOImplTest {
    @Test
    public void addElement_MethodSaveCalled(){
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Session session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);

        ElementDAOImpl<Bus> elementDAO = new ElementDAOImpl(Bus.class,sessionFactory);
        Bus bus = new Bus();
        elementDAO.addElement(bus);

        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).save(bus);
    }


    @Test
    public void updateElement_MethodUpdateCalled(){
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Session session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);

        ElementDAOImpl<Bus> elementDAO = new ElementDAOImpl(Bus.class,sessionFactory);
        Bus bus = new Bus();
        elementDAO.updateElement(bus);

        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).update(bus);
    }

    @Test
    public void getElementByID_MethodGetCalled(){
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Session session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);

        ElementDAOImpl<Bus> elementDAO = new ElementDAOImpl(Bus.class,sessionFactory);
        elementDAO.getElementByID(0);

        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).get(Bus.class,0);
    }

        @Test
    public void getAllElements_MethodGetCalled(){
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Session session = mock(Session.class);
        CriteriaBuilder cb = mock(CriteriaBuilder.class);
        CriteriaQuery cq = mock(CriteriaQuery.class);
        Root root = mock(Root.class);
        Query q = mock(Query.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.getCriteriaBuilder()).thenReturn(cb);
        when(cb.createQuery(Bus.class)).thenReturn(cq);
        when(cq.from(Bus.class)).thenReturn(root);
        when(session.createQuery(cq)).thenReturn(q);

        ElementDAOImpl<Bus> elementDAO = new ElementDAOImpl(Bus.class,sessionFactory);
        elementDAO.getAllElements();

        verify(sessionFactory, times(1)).getCurrentSession();
        verify(q, times(1)).getResultList();
    }


    @Test
    public void deleteElement_MethodDeleteCalled(){
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Session session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);

        ElementDAOImpl<Bus> elementDAO = new ElementDAOImpl(Bus.class,sessionFactory);
        Bus bus = new Bus();
        elementDAO.deleteElement(bus);

        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).delete(bus);
    }
}
