package jpa.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.concurrent.Callable;


public abstract class JPADaoOld<T, K> implements DAO<T, K> {

  protected final EntityManagerFactory emf;
  private final Class<T> entityClass;

  @SuppressWarnings("unchecked")
  public JPADaoOld() {
    this.emf = JPAFactory.getEmFactory("jpa");
    this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }
  
  // @Override
  // public void create(T t) {
  //   EntityManager em = emf.createEntityManager();
  //   EntityTransaction tx = em.getTransaction();

  //   try {
  //     tx.begin();
  //     em.persist(t);
  //     tx.commit();
  //   } catch (Exception ex) {
  //     if (tx != null && tx.isActive()) {
  //       tx.rollback();
  //     }
  //     throw new RuntimeException(ex);
  //   } finally {
  //     if (em != null && em.isOpen()) {
  //       em.close();
  //     }
  //   }
  // }




  @Override
  public void create(T t) {
    EntityManager em = emf.createEntityManager();
    Callable<Void> voidTask = () -> {
      em.persist(t);
      return null;
    };

    Util.runInTransaction(em, voidTask);
  }

  // @Override
  // public T read(K id) {
  //   EntityManager em = emf.createEntityManager();
  //   EntityTransaction tx = em.getTransaction();

  //   try {
  //     tx.begin();
  //     T entity = em.find(entityClass, id);
  //     tx.commit();
  //     return entity;
  //   } catch (Exception ex) {
  //     if (tx != null && tx.isActive()) {
  //       tx.rollback();
  //     }
  //     throw new RuntimeException(ex);
  //   } finally {
  //     if (em != null && em.isOpen()) {
  //       em.close();
  //     }
  //   }
  // }

  @Override
  public T read(K k) {
    EntityManager em = emf.createEntityManager();
    Callable<T> Task = () -> {
      return em.find(entityClass, k);
    };

    return Util.callInTransaction(em, Task);
  }

  // @Override
  // public void update(T t) {
  //   EntityManager em = emf.createEntityManager();
  //   EntityTransaction tx = em.getTransaction();
  //   try {
  //     tx.begin();
  //     if (!em.contains(t))
  //       em.merge(t);
  //     tx.commit();

  //   } catch (Exception ex) {
  //     if (tx != null && tx.isActive()) {
  //       tx.rollback();
  //     }
  //     throw new RuntimeException(ex);
  //   } finally {
  //     if (em != null && em.isOpen()) {
  //       em.close();
  //     }
  //   }
  // }


  @Override
  public void update(T t) {
    EntityManager em = emf.createEntityManager();
    Callable<Void> voidTask = () -> {
      em.merge(t);
      return null;
    };

    Util.runInTransaction(em, voidTask);
  }

  // @Override
  // public void delete(T t) {
  //   EntityManager em = emf.createEntityManager();
  //   EntityTransaction tx = em.getTransaction();

  //   try {
  //     tx.begin();
  //     // If entity is detached, merge it to get a managed entity
  //     // Customer managedCustomer = em.contains(customer) ? customer : em.merge(customer);

  //     //  merge returns an instance of the entity that is managed by the entity manager
  //     //  so we need to assign it to the customer variable
  //     if (!em.contains(t))
  //       t = em.merge(t);

  //     em.remove(t);
  //     tx.commit();
  //   } catch (Exception ex) {
  //     if (tx != null && tx.isActive()) {
  //       tx.rollback();
  //     }
  //     throw new RuntimeException(ex);
  //   } finally {
  //     if (em != null && em.isOpen()) {
  //       em.close();
  //     }
  //   }
  // }



  @Override
  public void delete(T t) {
    EntityManager em = emf.createEntityManager();
    Callable<Void> voidTask = () -> {
      T entity = em.contains(t) ? t : em.merge(t);
      em.remove(entity);
      return null;
    };

    Util.runInTransaction(em, voidTask);
  }

  // @Override
  // public List<T> readAll() {
  //   EntityManager em = emf.createEntityManager();
  //   EntityTransaction tx = em.getTransaction();

  //   try {
  //     tx.begin();
  //     TypedQuery<T> query = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
  //     List<T> customers = query.getResultList();
  //     tx.commit();
  //     return customers;
  //   } catch (Exception ex) {
  //     if (tx != null && tx.isActive()) {
  //       tx.rollback();
  //     }
  //     throw new RuntimeException(ex);
  //   } finally {
  //     if (em != null && em.isOpen()) {
  //       em.close();
  //     }
  //   }
  // }


  @Override
  public List<T> readAll() {
    EntityManager em = emf.createEntityManager();
    Callable<List<T>> Task = () -> {
      return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    };

    return Util.callInTransaction(em, Task);
  }
}
