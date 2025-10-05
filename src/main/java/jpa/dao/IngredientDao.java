package jpa.dao;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.EntityManager;
import jpa.domain.kristinaTest.Ingredient;
import jpa.domain.kristinaTest.Recipe;

public class IngredientDao extends JPADao<Recipe, Long> {
  
  public Set<Ingredient> getIngredientsByRecipeId(Long recipeId) {
    EntityManager em = emf.createEntityManager();
    // String jpql = "SELECT i FROM Ingredient i JOIN i.recipes r WHERE r.id = :recipeId";
    String jpql = "SELECT r FROM Recipe r JOIN FETCH r.ingredients";
    return new HashSet<>(em.createQuery(jpql, Ingredient.class)
        .setParameter("recipeId", recipeId)
        .getResultList());
  }
}


// EAGER doesn't prevent N+1 queries - it just makes them happen earlier.
// The real solution is using JOIN FETCH or batch fetching strategies.
// Your current approach with separate DAO queries is actually fine for simple cases,
// but JOIN FETCH is the industry standard for avoiding N+1 problems.