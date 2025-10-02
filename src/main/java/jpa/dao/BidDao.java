package jpa.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jpa.domain.Bid;

public class BidDao extends JPADao<Bid, Long> {

  public List<Bid> findByItemId(Long id) {
    EntityManager em = emf.createEntityManager();

    String jpql = "SELECT b FROM Bid b WHERE b.item.id = :id";
    return em.createQuery(jpql, Bid.class)
    .setParameter("id", id)
    .getResultList();
  }
}
