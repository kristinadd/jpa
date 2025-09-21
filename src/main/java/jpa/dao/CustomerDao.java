package jpa.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jpa.domain.Customer;

public class CustomerDao extends JPADaoOld<Customer, Long> {
  public Customer findByName(String name) {
    EntityManager em = emf.createEntityManager();

    String jpql = "SELECT c FROM Customer c WHERE c.name = :name";
    return em.createQuery(jpql, Customer.class)
      .setParameter("name", name)
      .getSingleResult();
  }

  public List<Customer> findByCity(String city) {
    EntityManager em = emf.createEntityManager();

    // 3 levels of nesting
    String jpql = "SELECT c FROM Customer c WHERE c.address.city.name = :city";
    return em.createQuery(jpql, Customer.class)
      .setParameter("city", city)
      .getResultList();
  }
 }
