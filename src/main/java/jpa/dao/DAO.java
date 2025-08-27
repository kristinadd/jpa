package jpa.dao;

import java.util.List;

// T is the type of the entity, K is the type of the id
public interface DAO<T, K> {
  void create(T t);
  T read(K id);
  void update(T t);
  void delete(T t);
  List<T> readAll();
}
