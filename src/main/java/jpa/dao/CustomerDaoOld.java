package jpa.dao;

import jakarta.persistence.Persistence; // persistence engine
import jakarta.persistence.TypedQuery;
import jpa.domain.Customer;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class CustomerDaoOld {

  private EntityManagerFactory emf;

  public CustomerDaoOld() {
    this.emf = Persistence.createEntityManagerFactory("jpa");
  }

  public void create(Customer customer) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
      tx.begin();
      em.persist(customer);
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

// not need to return because it's passed by reference 
  public void update(Customer customer) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      if (!em.contains(customer))
        em.merge(customer);
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

  public void delete(Customer customer) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
      tx.begin();
      // If entity is detached, merge it to get a managed entity
      // Customer managedCustomer = em.contains(customer) ? customer : em.merge(customer);

      //  merge returns an instance of the entity that is managed by the entity manager
      //  so we need to assign it to the customer variable
      if (!em.contains(customer))
        customer = em.merge(customer);

      em.remove(customer);
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

  //  need to pass 4L as id because it's a Long
  public Customer find(Long id) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
      tx.begin();
      Customer customer = em.find(Customer.class, id);
      tx.commit();
      return customer;
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

  public List<Customer> findAll() {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
      tx.begin();
      TypedQuery<Customer> query = em.createQuery("SELECT m FROM Customer m", Customer.class);
      List<Customer> customers = query.getResultList();
      tx.commit();
      return customers;
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
