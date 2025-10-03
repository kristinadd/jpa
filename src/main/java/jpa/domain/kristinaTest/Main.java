package jpa.domain.kristinaTest;

import jpa.dao.RecipeDao;

public class Main {
  
  public static void main(String[] args) {
    RecipeDao recipeDao = new RecipeDao();
    Recipe recipe = new Recipe();
    recipe.setName("Tasty Recipe");
  }
}
