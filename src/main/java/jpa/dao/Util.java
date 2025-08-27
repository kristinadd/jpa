package jpa.dao;

import java.util.concurrent.Callable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Util {
  public static void runInTransaction(EntityManager em, Callable<Void> action) {
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      action.call(); // functional programming
      tx.commit();
    } catch (Exception ex) {
      if (tx != null && tx.isActive()) {
        tx.rollback();
      }
      throw new RuntimeException(ex);
    } finally {
      if (em != null && em.isOpen()) {
        em.close();
      }
    }
  }


  public static <T> T callInTransaction(EntityManager em, Callable<T> action) {
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      T result = action.call(); // functional programming
      tx.commit();
      return result;
    } catch (Exception ex) {
      if (tx != null && tx.isActive()) {
        tx.rollback();
      }
      throw new RuntimeException(ex);
    } finally {
      if (em != null && em.isOpen()) {
        em.close();
      }
    }
  }
}
