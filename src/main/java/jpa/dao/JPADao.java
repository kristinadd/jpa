package jpa.dao;

import java.util.List;
import jakarta.persistence.EntityManagerFactory;
import java.lang.reflect.ParameterizedType;



public abstract class JPADao<T, K> implements DAO<T, K> {

  protected final EntityManagerFactory emf;
  private final Class<T> clazz;

  @SuppressWarnings("unchecked")
  public JPADao() {
    this.emf = JPAFactory.getEmFactory("jpa");
    this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }

  public T read(K k) {
    return emf.callInTransaction(em  -> {
      return em.find(clazz, k);
    });
  }

  public List<T> readAll() {
    return emf.callInTransaction(em  -> {
      return em.createQuery("from" + clazz.getSimpleName(), clazz).getResultList();
    });
  }

  public void create(T t) {
    emf.runInTransaction(em -> {
      em.persist(t);
    });
  }

  public void update(T t) {
    emf.runInTransaction(em -> {
      em.merge(t);
    });
  }

  public void delete(T t) {
    emf.runInTransaction(em -> {
      em.remove(t);
    });
  }
}
