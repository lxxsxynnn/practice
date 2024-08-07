package com.ohgiraffers.association.section02.onetomany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager manager;

    public void save(Order order) {
        manager.persist(order);
    }

    public List<Order> findOrderByOrderCode(int orderCode) {

        return manager.createQuery("select o from Order o where o.orderCode = :orderCode")
                .setParameter("orderCode", Integer.valueOf(orderCode))
                .getResultList();
    }
}
