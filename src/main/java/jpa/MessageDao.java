package jpa;


import jakarta.persistence.Persistence; // persistence engine
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class MessageDao {

  private EntityManagerFactory emf;

  public MessageDao() {
    this.emf = Persistence.createEntityManagerFactory("jpa");
  }

  public void create(Message message) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
      tx.begin();
      em.persist(message);
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
  public void update(Message message) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      if (!em.contains(message))
        em.merge(message);
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

  public void delete(Message message) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
      tx.begin();
      // If entity is detached, merge it to get a managed entity
      // Message managedMessage = em.contains(message) ? message : em.merge(message);

      //  merge returns an instance of the entity that is managed by the entity manager
      //  so we need to assign it to the message variable
      if (!em.contains(message))
        message = em.merge(message);

      em.remove(message);
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
  public Message find(Long id) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
      tx.begin();
      Message message = em.find(Message.class, id);
      tx.commit();
      return message;
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

  public List<Message> findAll() {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
      tx.begin();
      TypedQuery<Message> query = em.createQuery("SELECT m FROM Message m", Message.class);
      List<Message> messages = query.getResultList();
      tx.commit();
      return messages;
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
