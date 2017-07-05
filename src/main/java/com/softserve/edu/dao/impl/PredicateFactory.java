package com.softserve.edu.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.Map;

public class PredicateFactory<E> {

    Class<E> elementClass;

    public PredicateFactory(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    public Predicate[] createStringPredicates(
            Map<String, String> request, CriteriaBuilder cb,
            CriteriaQuery<E> cq, Root<E> root) {
        ArrayList<Predicate> predicates = new ArrayList<Predicate>();
        for (Map.Entry<String, String> entry : request.entrySet()) {
            if (!entry.getValue().equals("")) {
                predicates.add(createStringPredicate(
                        entry.getKey(), entry.getValue(), cb, cq, root));
            }
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }

    public Predicate createStringPredicate(
            String attributeName, String requestValue, CriteriaBuilder cb,
            CriteriaQuery<E> cq, Root<E> root) {
        EntityType<E> journeyType = root.getModel();
        return cb.equal(root.get(journeyType.getSingularAttribute(
                attributeName, String.class)), requestValue);
    }
}
